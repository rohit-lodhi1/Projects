package com.blog.app.service;

import com.blog.app.entity.Company;

public interface ICompanyService {
   
	public Company addCompany(Company commpany);
	
	public Company getCompanyById(Long id);
	
}
