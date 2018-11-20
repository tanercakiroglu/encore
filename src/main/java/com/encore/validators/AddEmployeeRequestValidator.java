package com.encore.validators;


import com.encore.requests.AddEmployeeRequest;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import util.EncoreValidationUtils;

@Component
public class AddEmployeeRequestValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(AddEmployeeRequest.class);
    }

    @Override
    public void validate(Object target, Errors errors) {

        EncoreValidationUtils.rejectIfEmptyOrWhitespace(errors,"employeeId","T.C kimlik numarası boş olmamalıdır.");
        EncoreValidationUtils.rejectIfNotValidTckn(errors,"employeeId","Geçerli bir T.C kimlik numarası giriniz");
        EncoreValidationUtils.rejectIfEmptyOrWhitespace(errors,"employeeName","Çalışanın ismi boş olmamalıdır.");
        EncoreValidationUtils.rejectIfEmptyOrWhitespace(errors,"employeeSurname","Çalışanın soyismi boş olmamalıdır.");
        EncoreValidationUtils.rejectIfEmptyOrWhitespace(errors,"employeeType","Çalışan tipi seçilmelidir.");
        EncoreValidationUtils.rejectIfEmptyOrWhitespace(errors,"employeeBirthDay","Çalışan doğum günü boş olmamalıdr.");
        EncoreValidationUtils.rejectIfEmptyOrWhitespace(errors,"employeePassportId","Çalışan pasaport numarası boş olmamalıdr.");
        EncoreValidationUtils.rejectIfEmptyOrWhitespace(errors,"employeePhone","Çalışan telefon numarası boş olmamalıdr.");
        EncoreValidationUtils.rejectIfEmptyOrWhitespace(errors,"employeeMail","Çalışan maili boş olmamalıdr.");
        EncoreValidationUtils.rejectIfEmptyOrWhitespace(errors,"employeeAddress","Çalışan adresi boş olmamalıdr.");
        EncoreValidationUtils.rejectIfLengthNotEqualToValue(errors,"employeePhone",10,"Çalışan pasaport numarası olmamalıdr.");
        EncoreValidationUtils.rejectIfNotValidEmail(errors,"employeeMail","Geçerli bir mail adresi giriniz.");
    }
}
