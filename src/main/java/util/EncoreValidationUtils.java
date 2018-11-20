package util;

import org.springframework.util.Assert;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import java.math.BigDecimal;
import java.util.List;

public class EncoreValidationUtils extends ValidationUtils {


    public static void rejectIfLengthLessThanMinimum(Errors errors, String field, int minimum, String errorCode) {
        Assert.notNull(errors, "Errors object must not be null");
        String fieldValue = errors.getFieldValue(field).toString();
        if(fieldValue.length() < minimum){
            errors.rejectValue(field, errorCode, null, null);
        }
    }

    public static void rejectIfLengthGreaterThanMaximum(Errors errors, String field, int maximum, String errorCode) {
        Assert.notNull(errors, "Errors object must not be null");
        String fieldValue = errors.getFieldValue(field).toString();
        if(fieldValue.length() > maximum){
            errors.rejectValue(field, errorCode, null, null);
        }
    }

    public static void rejectIfLengthNotEqualToValue(Errors errors, String field, int value, String errorCode) {
        Assert.notNull(errors, "Errors object must not be null");
        String fieldValue = errors.getFieldValue(field).toString();
        if(fieldValue.length() != value){
            errors.rejectValue(field, errorCode, null, null);
        }
    }

    public static void rejectIfLengthNotBetweenValues(Errors errors, String field, int minimum,int maximum, String errorCode) {
        Assert.notNull(errors, "Errors object must not be null");
        String fieldValue = errors.getFieldValue(field).toString();
        if(fieldValue.length() < minimum || fieldValue.length() > maximum){
            errors.rejectValue(field, errorCode, null, null);
        }
    }

    public static void rejectIfLessThanMinimum(Errors errors, String field, BigDecimal minimum, String errorCode) {
        Assert.notNull(errors, "Errors object must not be null");
        try {
            String fieldValue = errors.getFieldValue(field).toString();
            BigDecimal parsedFieldValue = BigDecimal.valueOf(Double.parseDouble(fieldValue));
            if(parsedFieldValue.compareTo(minimum) < 0){
                errors.rejectValue(field, errorCode, null, null);
            }
        } catch (NumberFormatException  e) {
            Assert.notNull(errors, "Errors object must be integer");
        }
    }

    public static void rejectIfGreaterThanMaximum(Errors errors, String field, int maximum, String errorCode)  {
        Assert.notNull(errors, "Errors object must not be null");
        try {
            String fieldValue = errors.getFieldValue(field).toString();
            BigDecimal parsedFieldValue = BigDecimal.valueOf(Double.parseDouble(fieldValue));
            Integer fieldValueInteger = Integer.valueOf(parsedFieldValue.intValue());
            if(fieldValueInteger != null && fieldValueInteger > maximum){
                errors.rejectValue(field, errorCode, null, null);
            }
        } catch (NumberFormatException  e) {
            Assert.notNull(errors, "Errors object must be integer");
        }
    }

    public static void rejectIfGreaterThanMaximumDoubleValue(Errors errors, String field, Double value, Double maximum, String errorCode)  {
        Assert.notNull(errors, "Errors object must not be null");
        try {
            if(value != null && value > maximum){
                errors.rejectValue(field, errorCode, null, null);
            }
        } catch (NumberFormatException  e) {
            Assert.notNull(errors, "Errors object must be integer");
        }
    }

    public static void rejectIfNotEqualToValue(Errors errors, String field, int value, String errorCode) {
        Assert.notNull(errors, "Errors object must not be null");
        try {
            Integer fieldValue = (Integer) errors.getFieldValue(field);
            if(fieldValue != value){
                errors.rejectValue(field, errorCode, null, null);
            }
        } catch (NumberFormatException  e) {
            Assert.notNull(errors, "Errors object must be integer");
        }
    }

    public static void rejectIfEqualToValue(Errors errors, String field, int value, String errorCode){
        Assert.notNull(errors, "Errors object must not be null");
        try {
            Integer fieldValue = (Integer) errors.getFieldValue(field);
            if(fieldValue == value){
                errors.rejectValue(field, errorCode, null, null);
            }
        } catch (NumberFormatException  e) {
            Assert.notNull(errors, "Errors object must be integer");
        }
    }

    public static void rejectIfNotBetweenValues(Errors errors, String field, int minimum,int maximum, String errorCode) {
        Assert.notNull(errors, "Errors object must not be null");
        try {
            Integer fieldValue = (Integer) errors.getFieldValue(field);
            if(fieldValue < minimum || fieldValue > maximum){
                errors.rejectValue(field, errorCode, null, null);
            }
        } catch (NumberFormatException  e) {
            Assert.notNull(errors, "Errors object must be integer");
        }
    }



    public static void rejectIfNotMatchesPattern(Errors errors, String field, String regex, String errorCode) {
        Assert.notNull(errors, "Errors object must not be null");
        if(errors.getFieldValue(field)==null){
            errors.rejectValue(field, errorCode, null, null);
        }
        String fieldValue = errors.getFieldValue(field).toString();
        if(!fieldValue.matches(regex)){
            errors.rejectValue(field, errorCode, null, null);
        }
    }
    public static void rejectIfNotInList(Errors errors, String field, List<?> list, String errorCode) {
        Assert.notNull(errors, "Errors object must not be null");
        Object fieldValue = errors.getFieldValue(field);
        Boolean contains = false;
        for (Object object : list) {
            if(object.equals(fieldValue)){
                contains = true;
                break;
            }
        }
        if(!contains){
            errors.rejectValue(field, errorCode, null, null);
        }
    }
    public static void rejectIfNotValidEmail(Errors errors, String field, String errorCode) {
        Assert.notNull(errors, "Errors object must not be null");
        String fieldValue = errors.getFieldValue(field).toString();
        if(!fieldValue.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")){
            errors.rejectValue(field, errorCode, null, null);
        }
    }

    public static void rejectIfNotValidCreditCard(Errors errors, String field, String errorCode){
        Assert.notNull(errors, "Errors object must not be null");
        String fieldValue = errors.getFieldValue(field).toString();
        if(!fieldValue.matches("^[0-9]*$")){
            errors.rejectValue(field, errorCode, null, null);
        }
    }

    public static void rejectIfFalse(Errors errors, String field, String errorCode) {
        Assert.notNull(errors, "Errors object must not be null");
        String fieldValue = errors.getFieldValue(field).toString();
        if(!Boolean.valueOf(fieldValue)){
            errors.rejectValue(field, errorCode, null, null);
        }
    }
    public static void rejectIfNotValidEnum(Errors errors, String field,Object[] enumValues, String errorCode) {
        Assert.notNull(errors, "Errors object must not be null");
        Object fieldValue = errors.getFieldValue(field);
        Boolean valid = false;
        if(fieldValue!=null){
            for (Object object : enumValues) {
                if(object.toString().equals(fieldValue.toString())){
                    valid = true;
                }
            }
        }
        if(!valid){
            errors.rejectValue(field, errorCode, null, null);
        }
    }











    public static void rejectIfNotValidTckn(Errors errors, String field, String errorCode) {

        Assert.notNull(errors, "Errors object must not be null");

        Object fieldValue = errors.getFieldValue(field);
        Boolean valid = false;
        if(fieldValue!=null){
            valid = isValidTCKN(fieldValue.toString());
        }

        if(!valid){
            errors.rejectValue(field, errorCode, null, null);
        }
    }

    public static void rejectIfGreaterThanMaximumBigDecimalValue(Errors errors, String field, BigDecimal value, BigDecimal maxPolicyLimit, String errorCode) {
        Assert.notNull(errors, "Errors object must not be null");
        try {
            if(value != null && value.compareTo(maxPolicyLimit) > 0){
                errors.rejectValue(field, errorCode, null, null);
            }
        } catch (NumberFormatException  e) {
            Assert.notNull(errors, "Errors object must be integer");
        }
    }

    private static boolean isValidTCKN(String tckn){
        if(tckn == null || tckn.length() != 11 || !isNumber(tckn) || tckn.startsWith("0")){
            return false;
        }
        int[] digits = new int[11];
        int total = 0, oddTotal = 0, evenTotal = 0;
        for(int i = 0; i < tckn.length(); i++){
            digits[i] =  Character.getNumericValue(tckn.charAt(i));
            total += i < 10 ? digits[i] : 0;
            evenTotal += i < 9 && i % 2 == 0 ? digits[i] : 0;
            oddTotal += i < 8 && i % 2 == 1 ? digits[i] : 0;
        }
        if( ((7 * evenTotal) - oddTotal) % 10 != digits[9] ){
            return false;
        }
        return total % 10 == digits[10];
    }

    private static boolean isNumber(String str) {
        if (str == null) {
            return false;
        }
        int length = str.length();
        if (length == 0) {
            return false;
        }
        int i = 0;
        if (str.charAt(0) == '-') {
            if (length == 1) {
                return false;
            }
            i = 1;
        }
        for (; i < length; i++) {
            char c = str.charAt(i);
            if ((c <= '/' || c >= ':') && c!='.' && c!=',') {
                return false;
            }
        }
        return true;
    }
}
