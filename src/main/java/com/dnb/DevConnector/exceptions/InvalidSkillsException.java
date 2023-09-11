package com.dnb.DevConnector.exceptions;

public class InvalidSkillsException extends Exception {
	public InvalidSkillsException(String msg) {
		super(msg);
	}

	@Override
	public String toString() {
		return super.toString() + super.getMessage();
	}
}
