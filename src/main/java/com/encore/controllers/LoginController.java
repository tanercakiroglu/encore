package com.encore.controllers;

import com.encore.icontrollers.ILoginController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController implements ILoginController {


    @Override
    public ModelAndView login(@RequestParam(value = "error", required = false) String error,
                              @RequestParam(value = "logout", required = false) String logout) {

        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error", "Invalid username and password!");
        }

        if (logout != null) {
            model.addObject("msg", "You've been logged out successfully.");
        }
        model.setViewName("login");

        return model;

    }

    @Override
    public ModelAndView internalError() {
        return new ModelAndView("500");
    }

    @Override
    public ModelAndView notFound() {
        return new ModelAndView("404");
    }

    @Override
    public ModelAndView forbidden() {
        return new ModelAndView("403");
    }


}
