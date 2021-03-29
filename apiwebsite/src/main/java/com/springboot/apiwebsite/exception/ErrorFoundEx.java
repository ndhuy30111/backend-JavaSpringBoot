package com.springboot.apiwebsite.exception;

public class ErrorFoundEx extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ErrorFoundEx(String message){
		super(message);
	}
}
