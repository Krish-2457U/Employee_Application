package com.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.employee.model.Company;
import com.employee.repository.CompanyRepository;

@Service
public class CompanyServiceImpl implements CompanyService {

	private CompanyRepository companyRepository;

	public CompanyServiceImpl(CompanyRepository companyRepository) {
		this.companyRepository = companyRepository;
	}

	@Override
	public List<Company> findAll() {
		return companyRepository.findAll();
	}

	@Override
	public Company createCompany(Company company) {
		return companyRepository.save(company);
	}

	@Override
	public boolean updateCompany(Company company, Long id) {
		Optional<Company> byId = companyRepository.findById(id);
		if (byId.isPresent()) {
			Company company2 = byId.get();
			company2.setName(company.getName());
			company2.setDescription(company.getDescription());
			company2.setEmployees(company.getEmployees());
			companyRepository.save(company2);
			return true;
		}
		return false;
	}

	@Override
	public Company getCompanyById(Long id) {
		return companyRepository.findById(id).orElse(null);
	}

	@Override
	public boolean deleteCompanyById(Long id) {
		boolean byId = companyRepository.existsById(id);
		if (byId) {
			companyRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

}
