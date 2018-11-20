package com.encore.services;

import com.encore.entities.Employee;
import com.encore.irepos.IEmployeeRepo;
import com.encore.iservices.IEmployeeService;
import com.encore.requests.AddEmployeeRequest;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmployeeService implements IEmployeeService {

    @Autowired
    private IEmployeeRepo employeeRepo;

    @Autowired
    private DozerBeanMapper mapper;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepo.findAll();
    }

    @Override
    public Employee addEmployee(AddEmployeeRequest request) {
        Employee employee = mapper.map(request, Employee.class);
        return employeeRepo.save(employee);
    }

    @Override
    public boolean removeEmployee(String id) {
        employeeRepo.deleteById(Long.valueOf(id));
        return true;
    }
}
