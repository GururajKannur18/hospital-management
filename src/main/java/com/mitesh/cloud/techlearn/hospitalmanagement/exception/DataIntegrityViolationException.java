package com.mitesh.cloud.techlearn.hospitalmanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class DataIntegrityViolationException extends RuntimeException{

	public DataIntegrityViolationException(String message) {
		super(message);
	}
	
}