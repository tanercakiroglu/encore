package com.encore.iservices;

import com.encore.entities.Employee;
import com.encore.requests.AddEmployeeRequest;

import java.util.List;

public interface IEmployeeService {

    List<Employee> getAllEmployees();
    Employee addEmployee(AddEmployeeRequest request);
    boolean removeEmployee(String id);
    Employee getEmployeeByEmail(String email);
}
