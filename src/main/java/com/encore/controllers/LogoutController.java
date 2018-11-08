package com.encore.controllers;

import org.springframework.web.servlet.ModelAndView;

import com.encore.icontrollers.ILogoutController;

public class LogoutController implements ILogoutController {
    @Override
    public ModelAndView logoutView() {
        return new ModelAndView("logout");
    }
}
