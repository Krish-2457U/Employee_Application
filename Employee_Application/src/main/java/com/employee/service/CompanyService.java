package com.employee.service;

import java.util.List;

import com.employee.model.Company;

public interface CompanyService {

	List<Company> findAll();
	
	Company createCompany(Company company);
	
	boolean updateCompany(Company company,Long id);
	
	Company getCompanyById(Long id);
	
	boolean deleteCompanyById(Long id);
}
