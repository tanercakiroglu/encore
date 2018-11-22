package com.encore.controllers;

import com.encore.entities.File;
import com.encore.icontrollers.IFileController;
import com.encore.iservices.IFileService;
import com.encore.responses.GetFileResponse;
import exceptions.BusinessException;
import org.apache.commons.codec.binary.Base64;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import util.JSONUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;

@RestController
public class FileController implements IFileController {

    @Autowired
    private IFileService fileService;

    @Autowired
    private DozerBeanMapper mapper;

    @Override
    public Object addFile(MultipartHttpServletRequest request, HttpServletResponse response) throws BusinessException {
        //0. notice, we have used MultipartHttpServletRequest
        //1. get the files from the request object
        Iterator<String> itr =  request.getFileNames();

        MultipartFile mpf = request.getFile(itr.next());
        System.out.println(mpf.getOriginalFilename() +" uploaded!");

        try {
            //just temporary save file info into ufile
            int length = mpf.getBytes().length;
            byte[] bytes = mpf.getBytes();
            String name = mpf.getOriginalFilename();
            String[] splittedArray = name.split("\\.");
            String type = splittedArray!= null? splittedArray[splittedArray.length-1]:null;
            fileService.saveFile(new File(name,bytes,type));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.OK).body(JSONUtil.getJSONResultWithSuccess(""));
    }

    @Override
    public Object getFile(@RequestParam("id")String id,HttpServletRequest request, HttpServletResponse response) throws BusinessException {

         File file=    fileService.getFileById(id);
         GetFileResponse res = new GetFileResponse(file.getId(),file.getFileName(),file.getFileData(),file.getFileType());
         return ResponseEntity.status(HttpStatus.OK).body(JSONUtil.getJSONResultWithSuccess(res));
    }
}
