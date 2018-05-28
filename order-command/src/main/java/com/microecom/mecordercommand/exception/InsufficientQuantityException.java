package com.microecom.mecordercommand.exception;

public class InsufficientQuantityException extends BaseRuntimeException {

	public InsufficientQuantityException(String message) {
		super(Code.INSUFFICIENT_QUANTITY, message);
	}

}
