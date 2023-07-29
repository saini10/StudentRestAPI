package com.saini.StudentRestAPI.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerConfiguration {

	@ExceptionHandler({StudentNotFoundException.class, EmailNotFoundException.class})
	public ResponseEntity<ErrorResponse> studentAndEmailNotFoundExceptionHandler(Exception exe){
		
		ErrorResponse response = 
				new ErrorResponse(exe.getMessage(),System.currentTimeMillis(),HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler({EmailAlreadyRegisteredException.class,FirstNameNotFoundException.class})
	public ResponseEntity<ErrorResponse> alreadyRegisteredExceptionHandler(Exception exe){
		
		ErrorResponse response = 
				new ErrorResponse(exe.getMessage(),System.currentTimeMillis(),HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
		
	}
	
	
	
	
}
