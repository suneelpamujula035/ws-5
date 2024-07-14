package com.employeeservice.exception;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {

	@ExceptionHandler(EmployeeNotFound.class)
	public ResponseEntity<Object> handleEmployeeNotFound(EmployeeNotFound enf) {
		return new ResponseEntity<Object>(
				new ApiException(enf.getMessage(), HttpStatus.NOT_FOUND, ZonedDateTime.now(ZoneId.of("Asia/Kolkata"))),
				HttpStatus.NOT_FOUND);
	}
}
