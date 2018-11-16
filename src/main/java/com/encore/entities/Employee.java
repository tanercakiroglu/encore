package com.encore.entities;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "employees")
public class Employee {

    @Id
    @Column(name = "tc_id")
    private Long employeeId;

    @Column(name = "employee_name")
    private String employeeName;

    @Column(name = "employee_surname")
    private String employeeSurname;

    @Column(name = "employee_type")
    private Integer employeeType;

    @Temporal(TemporalType.DATE)
    @Column(name = "employee_birth_date")
    private Date employeeBirthDay;

    @Column(name = "employee_passport_Id")
    private String employeePassportId;

    @Column(name = "employee_phone")
    private Long employeePhone;

    @Column(name = "employee_mail")
    private String employeeMail;

    @Column(name = "employee_address")
    private String employeeAddress;


    public Employee() {
        super();
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeSurname() {
        return employeeSurname;
    }

    public void setEmployeeSurname(String employeeSurname) {
        this.employeeSurname = employeeSurname;
    }

    public Integer getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(Integer employeeType) {
        this.employeeType = employeeType;
    }

    public Date getEmployeeBirthDay() {
        return employeeBirthDay;
    }

    public void setEmployeeBirthDay(Date employeeBirthDay) {
        this.employeeBirthDay = employeeBirthDay;
    }

    public String getEmployeePassportId() {
        return employeePassportId;
    }

    public void setEmployeePassportId(String employeePassportId) {
        this.employeePassportId = employeePassportId;
    }

    public Long getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(Long employeePhone) {
        this.employeePhone = employeePhone;
    }

    public String getEmployeeMail() {
        return employeeMail;
    }

    public void setEmployeeMail(String employeeMail) {
        this.employeeMail = employeeMail;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }
}
