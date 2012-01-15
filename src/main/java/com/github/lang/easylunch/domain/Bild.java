package com.github.lang.easylunch.domain;

public class Bild {

    private Long id;
    private byte[] data;
    private String filename;
    private String contentType;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
    
    public void setData(byte[] data) {
        this.data = data;
    }
    
    public byte[] getData() {
        return data;
    }
    
    public void setFilename(String filename) {
        this.filename = filename;
    }
    
    public String getFilename() {
        return filename;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getContentType() {
        return contentType;
    }

}
