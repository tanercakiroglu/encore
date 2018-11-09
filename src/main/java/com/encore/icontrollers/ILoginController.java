package com.encore.icontrollers;

import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.encore.requests.LoginRequest;

public interface ILoginController {

    @RequestMapping(value="/",method = RequestMethod.GET)
    public @ResponseBody
    ModelAndView loginView() ;

    @RequestMapping(value="/login",method = RequestMethod.POST,consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public @ResponseBody
    String login(@RequestParam("email") String email, @RequestParam("password") String password) ;

    @Secured("ROLE_USER")
    @RequestMapping(value="/app/secured/home",method = RequestMethod.GET)
    public @ResponseBody
    ModelAndView securedHome(@RequestBody LoginRequest request) ;
}
