package com.encore.icontrollers;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IEmployeeController {

    @Secured("ROLE_ADMIN")
    @RequestMapping(value="/secured/admin/employee",method = RequestMethod.GET)
    @ResponseBody
    ModelAndView employeeView(HttpServletRequest request, HttpServletResponse response) ;
}


