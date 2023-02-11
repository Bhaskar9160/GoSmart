package com.gosmart.controller;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gosmart.repository.VehicleTypeRepository;
import com.gosmart.repository.entity.VehicleTypeEntity;
import com.gosmart.service.VehicleTypeService;

@RunWith(SpringJUnit4ClassRunner.class)
public class VehicalTypeControllerTest {
	@InjectMocks
	private VehicaleTypeController controller;
	@Mock
	private VehicleTypeService service;
	@Test
	public void testInsertVehicleType()throws Exception
	{
		VehicleTypeEntity vehicleTypeEntity=new VehicleTypeEntity();
		Integer vehicleTypeId=1;
		when(service.insertVehicleType(vehicleTypeEntity)).thenReturn(vehicleTypeId);
		ResponseEntity<Integer> response=controller.insertVehicleType(vehicleTypeEntity);
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}
	@Test
	public void testInsertVehicleType_Exception()throws Exception
	{
		VehicleTypeEntity vehicleTypeEntity=new VehicleTypeEntity();
		
		when(service.insertVehicleType(vehicleTypeEntity)).thenThrow(NullPointerException.class);
		ResponseEntity<Integer> response=controller.insertVehicleType(vehicleTypeEntity);
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
	}
	@Test
	public void testgetVehicleType()throws Exception
	{
		Integer VehicleTypeId=1;
		List<VehicleTypeEntity>VehicleTypeList=new ArrayList<>();
		when(service.getVehicleTypes()).thenReturn(VehicleTypeList);
		ResponseEntity<List<VehicleTypeEntity>>responseEntity=controller.getVehicleTypes();
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}
	@Test
	public void testgetVehicleType_Exception()throws Exception
	{
		Integer VehicleTypeId=1;
		
		when(service.getVehicleTypes()).thenThrow(NullPointerException.class);
		ResponseEntity<List<VehicleTypeEntity>>responseEntity=controller.getVehicleTypes();
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());
	}
	@Test
	public void testGetVehicleType()throws Exception
	{
		Integer vehicleTypeId=1;
		VehicleTypeEntity vehicleType=new VehicleTypeEntity();
		when(service.getVehicleType(vehicleTypeId)).thenReturn(vehicleType);
		ResponseEntity<VehicleTypeEntity> responseEntity=controller.getVehicleType(vehicleType);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}
	@Test
	public void testGetVehicleType_Exception()throws Exception
	{
		Integer vehicleTypeId=1;
		
		when(service.getVehicleType(vehicleTypeId)).thenThrow(NullPointerException.class);
		VehicleTypeEntity vehicleType=new VehicleTypeEntity();
		ResponseEntity<VehicleTypeEntity> responseEntity=controller.getVehicleType(vehicleType);
		assertNotEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());
	}
	


}
