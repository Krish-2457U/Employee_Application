package com.employee.service;

import java.util.List;

import com.employee.model.Employee;

public interface EmployeeService {

	List<Employee> findAll();

	void createEmployee(Employee employee);

	boolean updateEmployee(Employee employee, Long id);

	Employee getEmployeeById(Long id);
	
	boolean deleteEmployeeById(Long id);
}
