package com.rest.messenger.exceptions;

public class DataNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4935964356494317431L;

	public DataNotFoundException(String message) {
		super(message);
	}
}
