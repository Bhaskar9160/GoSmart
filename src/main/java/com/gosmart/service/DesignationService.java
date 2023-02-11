package com.gosmart.service;

import java.util.List;

import com.gosmart.repository.entity.DesignationEntity;

public interface DesignationService {
	public Integer insertDesignation(DesignationEntity designationEntity);
	public List<DesignationEntity> getDesignations();
	public DesignationEntity getDesignations1(Integer designationId);
}
