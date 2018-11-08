package com.encore.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.encore.icontrollers.ISigninController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class SigninController implements ISigninController {
    @Override
    public ModelAndView loginView() {
        Map<String,Object> model = new HashMap<>();


        model.put("tovList","dsmfn");
        model.put("vechList","ms fmas");
        return new ModelAndView("signin",model);
    }
}
