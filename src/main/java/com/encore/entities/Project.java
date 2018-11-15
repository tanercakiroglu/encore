package com.encore.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity(name="projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "project_name")
    private String projectName;

    @Column(name = "project_owner")
    private String projectOwner;

    @Column(name = "project_status")
    private int projectStatus;

    @Column(name = "project_section")
    private int projectSection;

    @Column(name = "project_budget")
    private BigDecimal projectBudget;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "delivery_date")
    private Date deliveryDate;

    public Project() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectOwner() {
        return projectOwner;
    }

    public void setProjectOwner(String projectOwner) {
        this.projectOwner = projectOwner;
    }

    public int getProjectStatus() {
        return projectStatus;
    }

    public void setProjectStatus(int projectStatus) {
        this.projectStatus = projectStatus;
    }

    public int getProjectSection() {
        return projectSection;
    }

    public void setProjectSection(int projectSection) {
        this.projectSection = projectSection;
    }

    public BigDecimal getProjectBudget() {
        return projectBudget;
    }

    public void setProjectBudget(BigDecimal projectBudget) {
        this.projectBudget = projectBudget;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }
}
