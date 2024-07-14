package com.employeeservice.exception;

import java.time.ZonedDateTime;
import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiException {

	private String message;
	private HttpStatus httpStatus;
	private ZonedDateTime timestamp;
}
