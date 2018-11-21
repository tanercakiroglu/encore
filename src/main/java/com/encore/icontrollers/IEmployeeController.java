package com.encore.icontrollers;

import com.encore.requests.AddEmployeeRequest;
import exceptions.BusinessException;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IEmployeeController {

    @Secured("ROLE_ADMIN")
    @RequestMapping(value="/secured/admin/employee",method = RequestMethod.GET)
    @ResponseBody
    ModelAndView employeeView(HttpServletRequest request, HttpServletResponse response) ;

    @Secured("ROLE_ADMIN")
    @RequestMapping(value="/secured/admin/employee/add",method = RequestMethod.POST,produces = {MediaType.APPLICATION_JSON_UTF8_VALUE} )
    @ResponseBody
    Object addEmployee(@RequestBody AddEmployeeRequest req, HttpServletRequest request, HttpServletResponse response, Errors errors) ;

    @Secured("ROLE_ADMIN")
    @RequestMapping(value="/secured/admin/employee/remove",method = RequestMethod.POST,produces = {MediaType.APPLICATION_JSON_UTF8_VALUE} )
    @ResponseBody
    Object removeEmployee(@RequestBody String id, HttpServletRequest request, HttpServletResponse response) throws BusinessException;
}


