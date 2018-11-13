package com.encore.icontrollers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

public interface ILoginController {



    @RequestMapping(value = "/login", method = RequestMethod.GET)
    ModelAndView login(@RequestParam(value = "error", required = false) String error,
                              @RequestParam(value = "logout", required = false) String logout);


    @RequestMapping(value = "/403", method = RequestMethod.GET)
    ModelAndView forbidden();

    @RequestMapping(value = "/500", method = RequestMethod.GET)
    ModelAndView internalError();

    @RequestMapping(value = "/404", method = RequestMethod.GET)
    ModelAndView notFound();



}
