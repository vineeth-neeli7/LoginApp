package com.cg.loginapp.contoller;

/**
 * author --> Sai Vineeth Neeli 
 */


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class ExceptioHandler {
	
	@ExceptionHandler(SignUpExceptions.class)
	public ResponseEntity<String> signUpExceptions(SignUpExceptions s)
	{
		return new ResponseEntity<>(s.getMessage(),HttpStatus.BAD_REQUEST);
	}
    
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<String> userNotFoundException(UserNotFoundException s)
	{
		return new ResponseEntity<>(s.getMessage(),HttpStatus.BAD_REQUEST);
	}
}
 