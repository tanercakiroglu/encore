package com.encore.controllers;

import com.encore.icontrollers.IProjectController;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class ProjectController implements IProjectController {
    @Override
    public ModelAndView projectView(HttpServletRequest request, HttpServletResponse response) {
        return new ModelAndView("secured/project");
    }
}
