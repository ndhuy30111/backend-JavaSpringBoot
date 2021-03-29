package com.springboot.apiwebsite.exception;

public class BadRequestEx extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BadRequestEx(String message) {
		super(message);
	}

}
