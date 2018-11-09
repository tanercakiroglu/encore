package com.encore.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import configuration.CustomAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @Autowired
    private CustomAuthenticationProvider customAuthenticationProvider;



   /* @Override
    public ModelAndView login(@RequestParam("email") String email, @RequestParam("password") String password,HttpServletRequest request, HttpServletResponse response) {
        User user = loginService.getUserByUsernameAndPassword(email,password);
		if (user!=null) {

			return new ModelAndView("/secured/home","model","");
		} else
			throw new BadCredentialsException("User Bad Credential");
    }
*/
    @Override
    public ModelAndView securedHome(HttpServletRequest request, HttpServletResponse response) {
    	
    	Map<String,String> map = new HashMap<>();

    	map.put("token", "asd");
        return new ModelAndView("secured/home",map);
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(value = "error", required = false) String error,
                              @RequestParam(value = "logout", required = false) String logout) {

        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error", "Invalid username and password!");
        }

        if (logout != null) {
            model.addObject("msg", "You've been logged out successfully.");
        }
        model.setViewName("login");

        return model;

    }

    @RequestMapping(value = { "/", "/welcome**" }, method = RequestMethod.GET)
    public ModelAndView defaultPage() {

        ModelAndView model = new ModelAndView();
        model.addObject("title", "Spring Security Login Form - Database Authentication");
        model.addObject("message", "This is default page!");
        model.setViewName("hello");
        return model;

    }
}
