package com.microecom.mecordercommand.exception;

public class GetProductException extends BaseRuntimeException {

	public GetProductException(String message) {
		super(Code.GET_PRODUCT_EXCEPTION, message);
	}

}
