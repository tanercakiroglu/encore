package com.encore.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.encore.icontrollers.IHomeController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HomeController implements IHomeController {

    @Override
    public ModelAndView homeView() {
        Map<String,Object> model = new HashMap<>();


        model.put("tovList","dsmfn");
        model.put("vechList","ms fmas");
        return new ModelAndView("home",model);
    }

    @Override
    public String userHomeView() {
        return "OK";
    }

    @Override
    public ModelAndView proposalHomeView() {
        Map<String,String> map = new HashMap<>();
        map.put("token", "sfas");
        return new ModelAndView("secured/home",map);
    }
}
