package com.employeeservice.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeeservice.entity.Employee;
import com.employeeservice.entity.EmployeeResponse;
import com.employeeservice.exception.EmployeeNotFound;
import com.employeeservice.feignClient.AddressClient;
import com.employeeservice.repository.EmployeeRepository;
import com.employeeservice.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private AddressClient addressClient;

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee addEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public Employee getEmployee(int id) {
		return employeeRepository.findById(id)
				.orElseThrow(() -> new EmployeeNotFound("Employee not found with the id : " + id));
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		Employee existingEmployee = employeeRepository.findById(employee.getId())
				.orElseThrow(() -> new EmployeeNotFound("Employee not found with the id : " + employee.getId()));
		existingEmployee.setName(employee.getName());
		existingEmployee.setEmail(employee.getEmail());
		existingEmployee.setGender(employee.getGender());
		return employeeRepository.save(existingEmployee);
	}

	@Override
	public String deleteEmployee(int id) {
		employeeRepository.findById(id)
				.orElseThrow(() -> new EmployeeNotFound("Employee not found with the id : " + id));
		employeeRepository.deleteById(id);
		return "Employee deleted with the id : " + id;
	}

	@Override
	public EmployeeResponse getEmployeeWithAddress(int id) {
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new EmployeeNotFound("Employee not found with the id : " + id));
		String address = addressClient.getAddress().getBody();
		return new EmployeeResponse(employee.getId(), employee.getName(), employee.getEmail(), employee.getGender(), address);
	}
}
