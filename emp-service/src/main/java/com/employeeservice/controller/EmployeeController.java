package com.employeeservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employeeservice.entity.Employee;
import com.employeeservice.entity.EmployeeResponse;
import com.employeeservice.serviceImpl.EmployeeServiceImpl;

@RestController
@RequestMapping("/employee-app/api")
public class EmployeeController {

	@Autowired
	private EmployeeServiceImpl employeeServiceImpl;

	@GetMapping
	public ResponseEntity<List<Employee>> getAllEmployees() {
		return new ResponseEntity<List<Employee>>(employeeServiceImpl.getAllEmployees(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
		return new ResponseEntity<Employee>(employeeServiceImpl.addEmployee(employee), HttpStatus.CREATED);
	}

	@GetMapping("{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable int id) {
		return new ResponseEntity<Employee>(employeeServiceImpl.getEmployee(id), HttpStatus.ACCEPTED);
	}

	@PutMapping
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
		return new ResponseEntity<Employee>(employeeServiceImpl.updateEmployee(employee), HttpStatus.CREATED);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable int id) {
		return new ResponseEntity<String>(employeeServiceImpl.deleteEmployee(id), HttpStatus.OK);
	}

	@GetMapping("getEmployeeWithAddress/{id}")
	public ResponseEntity<EmployeeResponse> getEmployeeWithAddress(@PathVariable int id) {
		return new ResponseEntity<EmployeeResponse>(employeeServiceImpl.getEmployeeWithAddress(id),
				HttpStatus.ACCEPTED);
	}

}
