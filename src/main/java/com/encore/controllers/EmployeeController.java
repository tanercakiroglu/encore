package com.encore.controllers;

import com.encore.icontrollers.IEmployeeController;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class EmployeeController implements IEmployeeController {
    @Override
    public ModelAndView proposalView(HttpServletRequest request, HttpServletResponse response) {
        return new ModelAndView("secured/employee");
    }
}
