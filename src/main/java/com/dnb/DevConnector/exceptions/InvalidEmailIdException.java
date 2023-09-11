package com.dnb.DevConnector.exceptions;

public class InvalidEmailIdException extends Exception {
	public InvalidEmailIdException(String msg) {
		super(msg);
	}

	@Override
	public String toString() {
		return super.toString() + super.getMessage();

	}
}
