package com.gosmart.service;

import org.springframework.stereotype.Service;

import com.gosmart.repository.entity.AdminEntity;
import com.gosmart.repository.entity.BranchEntity;
@Service
public interface AdminService {
	
	public Integer insertAdmin(AdminEntity adminEntity);
	public AdminEntity getAdmin(String adminEmailId, String adminPassword);
	public AdminEntity getAdmin(String adminEmailId);  
	public void updateAdmin(AdminEntity adminEntity);  
	
}
