package com.codeversus.backend.exception;

@SuppressWarnings("serial")
public class ProblemNotFoundException extends RuntimeException
{
	public ProblemNotFoundException(String message) {
		super(message);
	}
}
