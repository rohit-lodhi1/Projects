package com.blog.app.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.app.Exceptions.CompanyNotFoundException;
import com.blog.app.entity.Company;
import com.blog.app.repository.ICompanyRepository;
import com.blog.app.service.ICompanyService;

@Service
public class CompanyServiceImpl implements ICompanyService{

	@Autowired
	private ICompanyRepository companyRepo;
	
	
	// To Add Company
	@Override
	public Company addCompany(Company commpany) {
		return this.companyRepo.save(commpany);
	}

	// To Get Company By ID 
	@Override
	public Company getCompanyById(Long id) {
		Company company = this.companyRepo.findById(id).orElseThrow(()->new CompanyNotFoundException("Company Not Found id : "+id));	
			return company;	 
	}

}
