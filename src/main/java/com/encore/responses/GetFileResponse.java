package com.encore.responses;

import javax.persistence.Column;

public class GetFileResponse {

    private Long id;

    private String fileName;

    private String fileData;

    private String fileType;

    public GetFileResponse(Long id, String fileName,String fileData, String fileType) {
        this.id = id;
        this.fileName = fileName;
        this.fileData = fileData;
        this.fileType = fileType;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileData() {
        return fileData;
    }

    public void setFileData(String fileData) {
        this.fileData = fileData;
    }
}
