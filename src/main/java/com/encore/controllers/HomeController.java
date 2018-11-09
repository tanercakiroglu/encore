package com.encore.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.encore.icontrollers.IHomeController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    public ModelAndView securedHome(HttpServletRequest request, HttpServletResponse response) {

        Map<String,String> map = new HashMap<>();

        map.put("token", "asd");
        return new ModelAndView("secured/home",map);
    }

}
