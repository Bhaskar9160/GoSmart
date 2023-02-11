package com.gosmart.service.impl;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gosmart.exception.GoSmartException;
import com.gosmart.repository.VehicleRepository;
import com.gosmart.repository.entity.VehicleEntity;

@RunWith(SpringJUnit4ClassRunner.class)
public class VehicleServiceImplTest {
	@InjectMocks
	private VehicleServiceImpl service;
	@Mock
	private VehicleRepository repository;
	@Test
	public void testInsertVehicle()throws Exception
	{
		VehicleEntity vehicleEntity=new VehicleEntity();
		VehicleEntity vehicleEntity2=Mockito.any();
		when(repository.save(vehicleEntity)).thenReturn(vehicleEntity2);
		Integer vehicleId=service.insertVehicle(vehicleEntity);
		assertNotNull(vehicleId);
		
	} 
	
	@Test(expected = GoSmartException.class)
	public void testInsertVehicle_Exception()throws Exception
	{
		VehicleEntity vehicleEntity=new VehicleEntity();
		VehicleEntity vehicleEntity2=Mockito.any();
		when(repository.save(vehicleEntity)).thenThrow(NullPointerException.class);
		service.insertVehicle(vehicleEntity);
	} 
	@Test
	public void testGetVehicles() throws Exception
	{
		Integer vehicleTypeId=1;
		List<VehicleEntity> vehicleList=new ArrayList<>();
		when(repository.findAllByVehicleTypeId(vehicleTypeId)).thenReturn(vehicleList);
		List<VehicleEntity> vehicles=service.getVehicles(vehicleTypeId);
		assertNotNull(vehicles);
	}
	
	@Test(expected = GoSmartException.class)
	public void testGetVehicle_Exception()throws Exception
	{
		Integer vehicleTypeId=1;
		when(repository.findAllByVehicleTypeId(vehicleTypeId)).thenThrow(NullPointerException.class);
		service.getVehicles(1);
		
	} 
	@Test
	public void testGetVehicles1() throws Exception
	{
		Integer vehicleId=1;
		VehicleEntity vehicleEntity=new VehicleEntity();
		VehicleEntity vehicleEntity2=Mockito.any();
		when(repository.findByVehicleId(vehicleId)).thenReturn(vehicleEntity);
		vehicleEntity=service.getVehicles1(vehicleId);
		assertNotNull(vehicleEntity);
	}
	@Test(expected = GoSmartException.class)
	public void testGetVehicles1_Exception() throws Exception
	{
		Integer vehicleId=1;
		when(repository.findByVehicleId(vehicleId)).thenThrow(NullPointerException.class);
		service.getVehicles1(vehicleId);
		
	}
}
