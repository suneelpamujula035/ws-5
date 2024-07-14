package com.employeeservice.service;

import java.util.List;

import com.employeeservice.entity.Employee;
import com.employeeservice.entity.EmployeeResponse;

public interface EmployeeService {

	List<Employee> getAllEmployees();
	Employee addEmployee(Employee employee);
	Employee getEmployee(int id);
	Employee updateEmployee(Employee employee);
	String deleteEmployee(int id);
	EmployeeResponse getEmployeeWithAddress(int id);
}
