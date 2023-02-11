package com.gosmart.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gosmart.constants.DesignationConstants;
import com.gosmart.exception.GoSmartException;
import com.gosmart.repository.DesignationRepository;
import com.gosmart.repository.entity.DesignationEntity;
import com.gosmart.service.DesignationService;

import lombok.extern.slf4j.Slf4j;
/**
 *  <h2>DesignationServiceImpl</h2>
 * */
@Service
@Slf4j
public class DesignationServiceImpl implements DesignationService{
	/**
	 * This method is used for the insertDesignation
	 * @param designationEntity this is the parameter to insertDesignation()
	 * @return Integer this returns designationId
	 * */
	
	@Autowired
	private DesignationRepository designationRepository;
	@Override
	public Integer insertDesignation(DesignationEntity designationEntity) {
		log.info("{}-ServiceImpl insertDesignation() started",DesignationConstants.DESIGNATION);
		Integer designationId=0;
		try {
			log.info("{}-ServiceImpl insertDesignation() saving designation",DesignationConstants.DESIGNATION);
			DesignationEntity designationEntity2=designationRepository.save(designationEntity);
			if(designationEntity2!=null)
			{
				designationId=designationEntity2.getDesignationId();
			}
		} catch (Exception e) {
			log.error("{}-ServiceImpl exception occured-{}",DesignationConstants.DESIGNATION,e.getMessage());
			throw new GoSmartException(e.getMessage());
		}
		return designationId;
	}
	@Override
	public List<DesignationEntity> getDesignations() {
		log.info("{}-ServiceImpl getDesignations() started",DesignationConstants.DESIGNATION);
		List<DesignationEntity> designations=null;
		try {
			log.info("{}-ServiceImpl getDesignations() saving designation",DesignationConstants.DESIGNATION);
			designations=designationRepository.findAll();
		} catch (Exception e) {
			log.error("{}-ServiceImpl exception occured-{}",DesignationConstants.DESIGNATION,e.getMessage());
			throw new GoSmartException(e.getMessage());
		}
		return designations;
	}
	@Override
	public DesignationEntity getDesignations1(Integer designationId) {
		log.info("{}-ServiceImpl getDesignations1() started",DesignationConstants.DESIGNATION);
		DesignationEntity designationEntity=null;
		try {
			log.info("{}-ServiceImpl getDesignations1() saving designation",DesignationConstants.DESIGNATION);
			designationEntity=designationRepository.findByDesignationId(designationId);
		} catch (Exception e) {
			log.error("{}-ServiceImpl exception occured-{}",DesignationConstants.DESIGNATION,e.getMessage());
			throw new GoSmartException(e.getMessage());
		}
		return designationEntity;
	}
	
}
