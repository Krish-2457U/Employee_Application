package com.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.employee.model.Employee;
import com.employee.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;

	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public List<Employee> findAll() {

		return employeeRepository.findAll();
	}

	@Override
	public void createEmployee(Employee employee) {
		employeeRepository.save(employee);
	}

	@Override
	public boolean updateEmployee(Employee employee, Long id) {

		Optional<Employee> optional = employeeRepository.findById(id);
		if (optional.isPresent()) {
			Employee employee2 = optional.get();
			employee2.setEmployeename(employee.getEmployeename());
			employee2.setSalary(employee.getSalary());
			employee2.setCategory(employee.getCategory());
			employee2.setGender(employee.getGender());
			employeeRepository.save(employee2);
			return true;
		}
		return false;

	}

	@Override
	public Employee getEmployeeById(Long id) {
		return employeeRepository.findById(id).orElse(null);
	}

	@Override
	public boolean deleteEmployeeById(Long id) {
		boolean delete = employeeRepository.existsById(id);
		if (delete) {
			employeeRepository.deleteById(id);
			return true;
		} else {

			return false;
		}
	}

}
