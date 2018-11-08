package com.encore.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.encore.icontrollers.IAboutUsController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class AboutUsController implements IAboutUsController {
    @Override
    public ModelAndView aboutView() {
        Map<String,Object> model = new HashMap<>();


        model.put("tovList","dsmfn");
        model.put("vechList","ms fmas");
        return new ModelAndView("about",model);
    }
}
