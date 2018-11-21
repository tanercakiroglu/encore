package com.encore.controllers;

import com.encore.entities.SelectOptions;
import com.encore.iservices.ISelectOptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.encore.icontrollers.IHomeController;
import util.SelectType;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class HomeController implements IHomeController {

    @Autowired
    private ISelectOptionService selectOptionService;

    @Override
    public ModelAndView homeView() {
        Map<String,Object> model = new HashMap<>();
        return new ModelAndView("home",model);
    }

    @Override
    public ModelAndView securedHome(HttpServletRequest request, HttpServletResponse response) {
        List<SelectOptions> selectList = selectOptionService.getAllSelectOptions();
        request.getSession().setAttribute("selectList",selectList);
        return new ModelAndView("secured/home");
    }

    @Override
    public ModelAndView admin() {

        return new ModelAndView("secured/admin");
    }

}
