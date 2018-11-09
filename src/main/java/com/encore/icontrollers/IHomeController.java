package com.encore.icontrollers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

public interface IHomeController {

    @RequestMapping(value="/home",method = RequestMethod.GET)
    public @ResponseBody
    ModelAndView homeView() ;

    @RequestMapping(value="/secured/user/home",method = RequestMethod.GET)
    public @ResponseBody
    ModelAndView userHomeView() ;

    @RequestMapping(value="/secured/user/proposal",method = RequestMethod.GET)
    public @ResponseBody
    ModelAndView proposalHomeView() ;
}
