package com.encore.validators;

import com.encore.requests.AddProductRequest;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import util.EncoreValidationUtils;

@Component
public class AddProductRequestValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(AddProductRequest.class);
    }

    @Override
    public void validate(Object target, Errors errors) {

        EncoreValidationUtils.rejectIfEmptyOrWhitespace(errors,"productName","Ürün ismi boş olmamalıdır.");
        EncoreValidationUtils.rejectIfEmptyOrWhitespace(errors,"productOwner","Ürün sorumlusu boş olmamalıdır.");
        EncoreValidationUtils.rejectIfEmptyOrWhitespace(errors,"productType","Ürün tipi seçilmelidir.");
        EncoreValidationUtils.rejectIfEmptyOrWhitespace(errors,"productHeight","Ürün boyu  boş olmamalıdr.");
        EncoreValidationUtils.rejectIfEmptyOrWhitespace(errors,"productWeight","Ürün eni   boş olmamalıdr.");
        EncoreValidationUtils.rejectIfEmptyOrWhitespace(errors,"productBuyPrice","Alış fiyatı boş olmamalıdr.");
        EncoreValidationUtils.rejectIfEmptyOrWhitespace(errors,"productSellPrice","Satış fiyatı boş olmamalıdr.");
        EncoreValidationUtils.rejectIfEmptyOrWhitespace(errors,"productSupplier","Ürün tedarikcisi boş olmamalıdr.");
    }
}
