package com.saini.StudentRestAPI.Exception;

public class EmailAlreadyRegisteredException extends IllegalArgumentException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1618338164399113413L;

	public EmailAlreadyRegisteredException(String message) {
		super(message);
	}
	
}
