package com.svecw.oes.exception;

public class OESException extends Exception {
	String message;

	public OESException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String toString() {
		return "oesException [message=" + message + "]";
	}

}
