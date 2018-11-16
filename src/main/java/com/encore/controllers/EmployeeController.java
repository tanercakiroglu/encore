package com.encore.controllers;

import com.encore.entities.Employee;
import com.encore.icontrollers.IEmployeeController;
import com.encore.iservices.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class EmployeeController implements IEmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    @Override
    public ModelAndView employeeView(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView("secured/employee");
        List<Employee> employeeList = employeeService.getAllEmployees();
        modelAndView.addObject("employees",employeeList);
        return modelAndView;
    }
}
