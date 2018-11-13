package com.encore.icontrollers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

public interface IContactController {

    @RequestMapping(value="/contact",method = RequestMethod.GET)
     @ResponseBody
    ModelAndView loginView() ;
}
