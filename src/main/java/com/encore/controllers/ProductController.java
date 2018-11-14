package com.encore.controllers;

import com.encore.icontrollers.IProductController;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class ProductController implements IProductController {
    @Override
    public ModelAndView productView(HttpServletRequest request, HttpServletResponse response) {
        return new ModelAndView("secured/product");
    }
}
