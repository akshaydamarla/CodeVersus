package com.codeversus.backend.exception;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	
	@ExceptionHandler(ProblemNotFoundException.class)
	public ResponseEntity<ApiError> handleProblemNotFound(ProblemNotFoundException ex){
		return buildResponse(HttpStatus.NOT_FOUND,ex.getMessage());
		
		
	}
	
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<ApiError> handleTypeMismatch(MethodArgumentTypeMismatchException ex){
		String message = "Invalid value '"+ex.getValue()+"' for parameter '"+ex.getName()+"'";
		
		Class<?> requiredType = ex.getRequiredType();
		if(requiredType != null && requiredType.isEnum()) {
			message += ". Allowed values: "+Arrays.toString(requiredType.getEnumConstants());
		}
		
		return buildResponse(HttpStatus.BAD_REQUEST,message);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ApiError> handleUnexcpeted(Exception ex){
		
		if(ex instanceof ErrorResponse errorResponse) {
			return buildResponse(errorResponse.getStatusCode(),errorResponse.getBody().getDetail());
		}
		
		
		log.error("Unexpected Error", ex);
		
		return buildResponse(HttpStatus.INTERNAL_SERVER_ERROR,"An Unexpected error occured!");
		
	}
	
	private ResponseEntity<ApiError> buildResponse(HttpStatusCode status, String message){
		ApiError body = new ApiError(
				Instant.now(),
				status.value(),
				HttpStatus.valueOf(status.value()).getReasonPhrase(),
				message);
		return ResponseEntity.status(status).body(body);
	}

}
