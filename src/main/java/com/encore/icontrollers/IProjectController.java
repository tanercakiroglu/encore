package com.encore.icontrollers;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IProjectController {

    @Secured("ROLE_USER")
    @RequestMapping(value="/secured/user/project",method = RequestMethod.GET)
    @ResponseBody
    ModelAndView projectView(HttpServletRequest request, HttpServletResponse response) ;
}