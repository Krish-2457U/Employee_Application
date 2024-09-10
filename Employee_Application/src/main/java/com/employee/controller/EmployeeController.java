package com.employee.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.model.Employee;
import com.employee.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@GetMapping
	public ResponseEntity<List<Employee>> findAll() {
		return new ResponseEntity<>(employeeService.findAll(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<String> createEmployee(@RequestBody Employee employee) {
		employeeService.createEmployee(employee);
		return new ResponseEntity<String>("Employee added succesfully!", HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<String> updateEmployee(@RequestBody Employee employee, @PathVariable Long id) {
		boolean updateEmployee = employeeService.updateEmployee(employee, id);
		if (updateEmployee) {
			return new ResponseEntity<String>("Employee updated succesfully!", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}

	}

	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
		Employee employeeById = employeeService.getEmployeeById(id);
		if (employeeById != null) {
			return new ResponseEntity<Employee>(employeeById, HttpStatus.OK);
		} else {
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteEmployeeById(@PathVariable Long id) {
		boolean deleteEmployeeById = employeeService.deleteEmployeeById(id);
		if (deleteEmployeeById) {
			return new ResponseEntity<String>("Employee deleted succesfully!", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("No Employee Found", HttpStatus.NOT_FOUND);

		}
	}

}
