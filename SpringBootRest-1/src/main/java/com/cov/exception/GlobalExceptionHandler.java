package com.cov.exception;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	Logger logger = Logger.getLogger(GlobalExceptionHandler.class);

	public ResponseEntity<String> aaa(InvalidPersonIdException invalidPersonIdException) {
		String errorResponse = invalidPersonIdException.getMessage();
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(value = InvalidPersonIdException.class)
	public ResponseEntity<ErrorResponse> invalidPersonIdHandler(InvalidPersonIdException invalidPersonIdException) {
		HttpStatus status = HttpStatus.NOT_FOUND;
		String message = invalidPersonIdException.getMessage();
		ErrorResponse errorResponse = new ErrorResponse(status, message);
		logger.info("status" + status);
		logger.info("message" + message);
		return new ResponseEntity<>(errorResponse, status);

	}

	public ResponseEntity<String> otherHandler(Exception exception) {
		String message = exception.getMessage();
		return new ResponseEntity<String>(message, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}