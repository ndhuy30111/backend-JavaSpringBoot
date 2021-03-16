package com.springboot.apiwebsite.exception;

public class ProductEx extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProductEx(String message)
	{
		super(message);
	}
}
