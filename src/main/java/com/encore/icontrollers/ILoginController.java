package com.encore.icontrollers;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.encore.requests.LoginRequest;

public interface ILoginController {

    @RequestMapping(value="/login",method = RequestMethod.GET)
    public @ResponseBody
    ModelAndView loginView() ;

    @RequestMapping(value="/login",method = RequestMethod.POST)
    public @ResponseBody
    String login(@RequestBody LoginRequest request) ;
}
