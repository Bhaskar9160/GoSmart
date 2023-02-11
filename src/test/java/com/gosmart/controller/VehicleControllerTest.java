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
import com.gosmart.repository.entity.VehicleEntity;
import com.gosmart.service.VehicleService;

@RunWith(SpringJUnit4ClassRunner.class)
public class VehicleControllerTest {
	@InjectMocks
	private VehicleController vehicleController;
	@Mock
	private VehicleService service;
	@Test
	public void testInsertVehicle() throws Exception
	{
		VehicleEntity vehicleEntity=new VehicleEntity();
		Integer vehicleId=1;
		when(service.insertVehicle(vehicleEntity)).thenReturn(vehicleId);
		ResponseEntity<Integer> response=vehicleController.insertVehicle(vehicleEntity);
		assertEquals(HttpStatus.CREATED, response.getStatusCode());
	}
	@Test
	public void testInsertVehicle_Exception() throws Exception
	{
		VehicleEntity vehicleEntity=new VehicleEntity();
		when(service.insertVehicle(vehicleEntity)).thenThrow(NullPointerException.class);
		ResponseEntity<Integer> response=vehicleController.insertVehicle(vehicleEntity);
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
	}
	@Test
	public void testGetVehicles() throws Exception
	{
		Integer vehicleTypeId=1;
		List<VehicleEntity> vehicleList=new ArrayList<>();
		when(service.getVehicles(vehicleTypeId)).thenReturn(vehicleList);
		ResponseEntity<List<VehicleEntity>> response=vehicleController.getVehicles(vehicleTypeId);
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}
	
	@Test
	public void testGetVehicles_Exception() throws Exception
	{
		Integer vehicleTyId=1;
		when(service.getVehicles(vehicleTyId)).thenThrow(NullPointerException.class);
		ResponseEntity<List<VehicleEntity>> response=vehicleController.getVehicles(vehicleTyId);
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
	}
	@Test
	public void testGetVehicles1() throws Exception
	{
		Integer vehicleId=1;
		VehicleEntity vehicleEntity=new VehicleEntity();
		when(service.getVehicles1(vehicleId)).thenReturn(vehicleEntity);
		ResponseEntity<VehicleEntity> response=vehicleController.getVehicles1(vehicleId);
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}
	@Test
	public void testGetVehicles1_Exception() throws Exception
	{
		Integer vehicleId=1;
		
		when(service.getVehicles1(vehicleId)).thenThrow(NullPointerException.class);
		ResponseEntity<VehicleEntity> response=vehicleController.getVehicles1(vehicleId);
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
	}
	
}
