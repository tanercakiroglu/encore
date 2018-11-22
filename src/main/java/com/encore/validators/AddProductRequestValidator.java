package com.encore.validators;

import com.encore.requests.AddProductRequest;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class AddProductRequestValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(AddProductRequest.class);
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
