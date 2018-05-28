package com.microecom.mecordercommand.exception;

import java.util.Date;

public class ExceptionResponse {
    private Date timestamp;
    private Integer code;
    private String message;
    private String details;

    public ExceptionResponse(Date timestamp, Integer code, String message, String details) {
        super();
        this.code = code;
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }

}
