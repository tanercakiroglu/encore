package com.encore.requests;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class AddEmployeeRequest {

    private Long employeeId;

    private String employeeName;

    private String employeeSurname;

    private Integer employeeType;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date employeeBirthDay;

    private String employeePassportId;

    private Long employeePhone;

    private String employeeMail;

    private String employeeAddress;

    public AddEmployeeRequest() {
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
