package com.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.model.Company;

public interface CompanyRepository extends JpaRepository<Company, Long>{

}
