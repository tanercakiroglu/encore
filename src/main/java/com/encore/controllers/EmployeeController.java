package com.encore.controllers;

import com.encore.entities.Employee;
import com.encore.icontrollers.IEmployeeController;
import com.encore.iservices.IEmployeeService;
import com.encore.requests.AddEmployeeRequest;
import com.encore.validators.AddEmployeeRequestValidator;
import exceptions.BusinessException;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import util.JSONUtil;
import util.SelectType;
import util.Utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class EmployeeController extends BaseController implements IEmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private AddEmployeeRequestValidator validator;


    @Override
    public ModelAndView employeeView(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView("secured/employee");
        List<Employee> employeeList = employeeService.getAllEmployees();
        modelAndView.addObject("employeeSelectList", Utils.getSelectOptionByType(request, SelectType.EMPLOYEE_TYPE.getValue()));
        modelAndView.addObject("employees", employeeList);
        return modelAndView;
    }

    @Override
    public Object addEmployee(@RequestBody AddEmployeeRequest req, HttpServletRequest request, HttpServletResponse response, Errors errors) {
        validator.validate(req, errors);
        if (errors.hasErrors())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(getJSONValidationResult(errors));
        employeeService.addEmployee(req);
        List<Employee> employeeList = employeeService.getAllEmployees();
        return ResponseEntity.status(HttpStatus.OK).body(JSONUtil.getJSONResultWithSuccess(employeeList));
    }

    @Override
    public Object removeEmployee(@RequestBody String id, HttpServletRequest request, HttpServletResponse response) throws BusinessException {

        if (StringUtils.isEmpty(id))
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONUtil.getJSONResultWithValidationError("Silinecek satırın T.C kimlik numarası boş olamaz"));
        employeeService.removeEmployee(id);
        List<Employee> employeeList = employeeService.getAllEmployees();
        return ResponseEntity.status(HttpStatus.OK).body(JSONUtil.getJSONResultWithSuccess(employeeList));
    }
}
