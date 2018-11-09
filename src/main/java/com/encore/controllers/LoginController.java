package com.encore.controllers;

import com.encore.entities.User;
import com.encore.icontrollers.ILoginController;
import com.encore.iservices.ILoginService;
import com.encore.iservices.ITokenService;
import com.encore.requests.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController implements ILoginController {

    @Autowired
    private ILoginService loginService;

    @Autowired
    private ITokenService tokenService;

    @Override
    public ModelAndView loginView() {
        Map<String,Object> model = new HashMap<>();


        model.put("tovList","dsmfn");
        model.put("vechList","ms fmas");
        return new ModelAndView("login",model);
    }

    @Override
    public String login(@RequestParam("email") String email, @RequestParam("password") String password) {
        User user = loginService.getUserByUsernameAndPassword(email,password);
        if(loginService.getUserByUsername(email))
            return "redirect:/app/secured/home";
    	if(user!=null){
           return "redirect:/app/secured/home";
        }else
        throw new BadCredentialsException("User Bad Credential");
    }

    @Override
    public ModelAndView securedHome(LoginRequest request) {
        Map<String,Object> model = new HashMap<>();


        model.put("tovList","dsmfn");
        model.put("vechList","ms fmas");
        return new ModelAndView("login",model);
    }
}
