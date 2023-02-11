package com.gosmart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gosmart.constants.DesignationConstants;
import com.gosmart.repository.entity.DesignationEntity;
import com.gosmart.service.DesignationService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/api/v1")
public class DesignationController {
	@Autowired
	private DesignationService designationService;
	
	@PostMapping("/designation/save")
	public ResponseEntity<Integer> insertDesignation(@RequestBody DesignationEntity designationEntity)
	{
		log.info("{}-Controller insertDesignation() started",DesignationConstants.DESIGNATION);
		try {
			log.info("{}-Controller insertDesignation() saving designation",DesignationConstants.DESIGNATION);
			Integer designationId=designationService.insertDesignation(designationEntity);
			return new ResponseEntity<>(designationId,HttpStatus.CREATED);
		} catch (Exception e) {
			log.error("{}-Controller exception occured-{}",DesignationConstants.DESIGNATION,e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/designation/designations")
	public ResponseEntity<List<DesignationEntity>> getDesignations()
	{
		List<DesignationEntity> designations=null;
		log.info("{}-Controller getDesignations() started",DesignationConstants.DESIGNATION);
		try {
			log.info("{}-Controller getDesignations() saving designation",DesignationConstants.DESIGNATION);
			designations=designationService.getDesignations();
			return new ResponseEntity<>(designations,HttpStatus.OK);
		} catch (Exception e) {
			log.error("{}-Controller exception occured-{}",DesignationConstants.DESIGNATION,e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	@GetMapping("/designation/designations1/{designationId}")
	public ResponseEntity<DesignationEntity> getDesignations1(@PathVariable Integer designationId)
	{
		log.info("{}-Controller getDesignations1() started",DesignationConstants.DESIGNATION);
		try {
			log.info("{}-Controller getDesignations1() saving designation",DesignationConstants.DESIGNATION);
			DesignationEntity designation1=designationService.getDesignations1(designationId);
			return new ResponseEntity<>(designation1,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
