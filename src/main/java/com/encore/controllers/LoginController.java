package com.encore.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.encore.entities.User;
import com.encore.icontrollers.ILoginController;
import com.encore.iservices.ILoginService;
import com.encore.iservices.ITokenService;

@Controller
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
    public ModelAndView login(@RequestParam("email") String email, @RequestParam("password") String password,HttpServletRequest request, HttpServletResponse response) {
        User user = loginService.getUserByUsernameAndPassword(email,password);
		if (user!=null) {
			String token =tokenService.createAndSaveToken(user.getUsername());
			return new ModelAndView("/secured/home","model",token);
		} else
			throw new BadCredentialsException("User Bad Credential");
    }

    @Override
    public ModelAndView securedHome(HttpServletRequest request, HttpServletResponse response) {
    	
    	Map<String,String> map = new HashMap<>();
    	String header = request.getHeader("Location");
    	map.put("token", header);
        return new ModelAndView("secured/home",map);
    }
}
