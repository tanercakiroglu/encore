package com.encore.irepos;

import com.encore.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeRepo extends JpaRepository<Employee,Long> {
    Employee findByEmployeeMail(String email);
}
