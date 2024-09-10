package com.employee.controller;

import java.util.List;

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

import com.employee.model.Company;
import com.employee.service.CompanyService;

@RestController
@RequestMapping("/companies")
public class CompanyController {

	private CompanyService companyService;

	public CompanyController(CompanyService companyService) {
		this.companyService = companyService;
	}

	@GetMapping
	public List<Company> findAll() {
		return companyService.findAll();
	}

	@PostMapping
	public ResponseEntity<String> createCompany(@RequestBody Company company) {
		companyService.createCompany(company);
		return new ResponseEntity<String>("Company added succesfully!", HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<String> updateCompany(@RequestBody Company company, @PathVariable Long id) {
		companyService.updateCompany(company, id);
		return new ResponseEntity<String>("Company updated succesfully!", HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Company> getCompanyById(@PathVariable Long id) {
		return new ResponseEntity<Company>(companyService.getCompanyById(id), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCompanyById(@PathVariable Long id)
	{
		boolean deleteCompanyById = companyService.deleteCompanyById(id);
		if (deleteCompanyById) {
			return new ResponseEntity<String>("Company deleted succesfully!", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("No Company Found", HttpStatus.NOT_FOUND);
		}
	}
}
