package com.encore.icontrollers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

public interface ILoginController {

    @RequestMapping(value="/",method = RequestMethod.GET)
    public @ResponseBody
    ModelAndView loginView() ;

    @RequestMapping(value="/login",method = RequestMethod.POST,consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public @ResponseBody
    ModelAndView login(@RequestParam("email") String email, @RequestParam("password") String password,HttpServletRequest request, HttpServletResponse response) ;

    @Secured("ROLE_USER")
    @RequestMapping(value="/secured/home",method = RequestMethod.POST)
    public @ResponseBody
    ModelAndView securedHome( HttpServletRequest request, HttpServletResponse response) ;
}
