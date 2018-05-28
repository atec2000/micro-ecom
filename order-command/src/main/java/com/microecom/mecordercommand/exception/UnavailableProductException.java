package com.microecom.mecordercommand.exception;

public class UnavailableProductException extends BaseRuntimeException {

	public UnavailableProductException(String message) {
		super(Code.UNAVAILABLE_PRODUCT, message);
	}

}
