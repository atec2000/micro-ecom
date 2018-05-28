package com.microecom.meccatalogquery.exception;

public class BaseRuntimeException extends RuntimeException {

    private Integer code;

    public Integer getCode() {
        return code;
    }

    public BaseRuntimeException(Integer code, String message) {
        super(message);
		this.code = code;
	}

}
