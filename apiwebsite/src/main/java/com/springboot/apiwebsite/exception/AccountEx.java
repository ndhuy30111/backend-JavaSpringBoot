package com.springboot.apiwebsite.exception;

public class AccountEx  extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AccountEx(String message) {
		super(message);
	}

}
