package com.encore.iservices;

import com.encore.entities.File;

import javax.servlet.http.HttpServletRequest;

public interface IFileService {

    boolean saveFile(File file);
    File getFileById(String id);
}
