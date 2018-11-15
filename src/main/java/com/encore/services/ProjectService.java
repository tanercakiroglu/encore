package com.encore.services;

import com.encore.entities.Project;
import com.encore.irepos.IProjectRepo;
import com.encore.iservices.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProjectService implements IProjectService {
    @Autowired
    private IProjectRepo projectRepo;

    @Override
    public List<Project> getAllProjects() {
        return projectRepo.findAll();
    }
}
