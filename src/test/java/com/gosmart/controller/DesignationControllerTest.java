package com.gosmart.controller;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gosmart.exception.GoSmartException;
import com.gosmart.repository.entity.DesignationEntity;
import com.gosmart.service.DesignationService;

@RunWith(SpringJUnit4ClassRunner.class)
public class DesignationControllerTest {
	@InjectMocks
	private DesignationController desinationController;
	@Mock
	private DesignationService service;
	@Test
	public void testInsertDesignation()throws Exception
	{
		DesignationEntity designationEntity=new DesignationEntity();
		Integer designationId=1;
		when(service.insertDesignation(designationEntity)).thenReturn(designationId);
		ResponseEntity<Integer> response=desinationController.insertDesignation(designationEntity);
		assertEquals(HttpStatus.CREATED, response.getStatusCode());
		
	}
	@Test
	public void testInsertDesignation_Exception()throws Exception
	{
		DesignationEntity designationEntity=new DesignationEntity();
		
		when(service.insertDesignation(designationEntity)).thenThrow(NullPointerException.class);
		ResponseEntity<Integer> response=desinationController.insertDesignation(designationEntity);
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
		
	}
	@Test
	public void testGetDesignations()throws Exception
	{
		List<DesignationEntity> designationList=new ArrayList<>();
		
		when(service.getDesignations()).thenReturn(designationList);
		ResponseEntity<List<DesignationEntity>> response=desinationController.getDesignations();
		assertEquals(HttpStatus.OK, response.getStatusCode());
		
	}
	@Test
	public void testgetDesignations_Exception()throws Exception
	{
		
		
		when(service.getDesignations()).thenThrow(NullPointerException.class);
		ResponseEntity<List<DesignationEntity>> response=desinationController.getDesignations();
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
		
	}
	@Test
	public void testGetDesignations1()throws Exception
	{
		DesignationEntity designationEntity=new DesignationEntity();
		Integer designationId=1;
		when(service.getDesignations1(designationId)).thenReturn(designationEntity);
		ResponseEntity<DesignationEntity> response=desinationController.getDesignations1(designationId);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		
	}
	@Test
	public void testGetDesignations1_Exception()throws Exception
	{
		
		Integer designationId=1;
		when(service.getDesignations1(designationId)).thenThrow(NullPointerException.class);
		ResponseEntity<DesignationEntity> response=desinationController.getDesignations1(designationId);
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
		
	}
	
	
}
