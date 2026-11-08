package com.codeversus.backend.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(ProblemNotFoundException.class)
	public ResponseEntity<Map<String,Object>> handleProblemNotFound(ProblemNotFoundException ex){
		Map<String,Object> response = new HashMap<>();
		
		response.put("message",ex.getMessage());
		response.put("status", 404);
		return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
		
	}

}
