package com.cg.loginapp.contoller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//import com.cg.loginapp.contoller.*;

@RestControllerAdvice
public class ExceptioHandler {
	
	@ExceptionHandler(SignUpExceptions.class)
	public ResponseEntity<String> signupexceptions(SignUpExceptions s)
	{
		return new ResponseEntity<>(s.getMessage(),HttpStatus.BAD_REQUEST);
	}

}
