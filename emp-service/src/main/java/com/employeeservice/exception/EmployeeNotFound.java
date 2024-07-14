package com.employeeservice.exception;

public class EmployeeNotFound extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 581589417531333044L;

	public EmployeeNotFound() {
		super();
	}

	public EmployeeNotFound(String message) {
		super(message);
	}
}
