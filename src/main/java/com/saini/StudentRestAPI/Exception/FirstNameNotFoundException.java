package com.saini.StudentRestAPI.Exception;

public class FirstNameNotFoundException extends IllegalArgumentException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public FirstNameNotFoundException(String message) {
		super(message);
	}
}
