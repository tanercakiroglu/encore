package com.encore.controllers;

import configuration.JSONUtil;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class BaseController {

    public String getJSONValidationResult(Errors results) {
        Map<String,String> errors = new HashMap<>();
        for (ObjectError error : results.getAllErrors()) {
            if(error instanceof FieldError){
                FieldError fieldError = (FieldError)error;
                errors.put(fieldError.getField(), (fieldError.getCode()));
            }else{
                errors.put(error.getObjectName(), (error.getCode()));
            }
        }
        return JSONUtil.getJSONResultWithValidationError((errors.values()));
    }
}
