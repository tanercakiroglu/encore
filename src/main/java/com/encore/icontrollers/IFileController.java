package com.encore.icontrollers;

import exceptions.BusinessException;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IFileController {



    @Secured("ROLE_USER")
    @RequestMapping(value="/secured/user/product/file/add",method = RequestMethod.POST )
    @ResponseBody
    Object addFile(MultipartHttpServletRequest request, HttpServletResponse response) throws BusinessException;

    @Secured("ROLE_USER")
    @RequestMapping(value="/secured/user/product/file/get",method = RequestMethod.GET )
    @ResponseBody
    Object getFile(@RequestParam("id")String id, HttpServletRequest request, HttpServletResponse response) throws BusinessException;
}
