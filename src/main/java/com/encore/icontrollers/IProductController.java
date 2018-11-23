package com.encore.icontrollers;

import com.encore.requests.AddProductRequest;
import exceptions.BusinessException;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IProductController {

    @Secured("ROLE_USER")
    @RequestMapping(value="/secured/user/product",method = RequestMethod.GET)
    @ResponseBody
    ModelAndView productView(HttpServletRequest request, HttpServletResponse response) ;

    @Secured("ROLE_USER")
    @RequestMapping(value="/secured/user/product/add",method = RequestMethod.POST)
    @ResponseBody
    Object addProductView(@RequestBody AddProductRequest req, HttpServletRequest request, HttpServletResponse response, Errors errors) ;

    @Secured("ROLE_USER")
    @RequestMapping(value="/secured/user/product/remove",method = RequestMethod.POST,produces = {MediaType.APPLICATION_JSON_UTF8_VALUE} )
    @ResponseBody
    Object removeEmployee(@RequestBody String id, HttpServletRequest request, HttpServletResponse response) ;
}
