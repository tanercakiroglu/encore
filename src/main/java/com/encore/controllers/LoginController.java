package com.encore.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.encore.icontrollers.ILoginController;
import com.encore.iservices.ILoginService;
import com.encore.requests.LoginRequest;

@RestController
public class LoginController implements ILoginController {

    @Autowired
    private ILoginService loginService;

    @Override
    public ModelAndView loginView() {
        Map<String,Object> model = new HashMap<>();


        model.put("tovList","dsmfn");
        model.put("vechList","ms fmas");
        return new ModelAndView("login",model);
    }

    @Override
    public String login(@RequestBody  LoginRequest request) {
    	boolean user=loginService.getUserByUsername(request.getUsername());
        return String.valueOf(user);
    }
}
