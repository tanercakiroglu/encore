package com.encore.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.encore.icontrollers.IContactController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ContactController implements IContactController {
    @Override
    public ModelAndView loginView() {
        Map<String,Object> model = new HashMap<>();


        model.put("tovList","dsmfn");
        model.put("vechList","ms fmas");
        return new ModelAndView("contact",model);
    }
}
