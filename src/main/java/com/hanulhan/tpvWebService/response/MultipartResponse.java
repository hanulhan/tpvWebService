package com.hanulhan.tpvWebService.response;

import java.util.Date;

public class MultipartResponse {
    private String status;
    private String file;
    private Date timestamp;

    public MultipartResponse(String status, String file, Date timestamp) {
        this.status = status;
        this.file = file;
        this.timestamp = timestamp;
    }

    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }
    
}
