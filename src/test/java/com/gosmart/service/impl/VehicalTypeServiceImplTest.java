package com.gosmart.service.impl;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gosmart.exception.GoSmartException;
import com.gosmart.repository.VehicleTypeRepository;
import com.gosmart.repository.entity.VehicleTypeEntity;

@RunWith(SpringJUnit4ClassRunner.class)
public class VehicalTypeServiceImplTest {
	@InjectMocks
	private VehicaleTypeServiceImpl service;
	@Mock
	private VehicleTypeRepository repository;
	@Test
	public void testinsertVehicleType() throws Exception
	{
		VehicleTypeEntity vehicleTypeEntity=new VehicleTypeEntity();
		vehicleTypeEntity.setVehicleTypeId(1);
		VehicleTypeEntity vehicleTypeEntity2=Mockito.any();
		when(repository.save(vehicleTypeEntity)).thenReturn(vehicleTypeEntity2);
		Integer vehicleTypeId=service.insertVehicleType(vehicleTypeEntity);
		assertNotNull(vehicleTypeId);
	}
	@Test(expected = GoSmartException.class)
	public void testinsertVehicleType_Exception() throws Exception
	{
		VehicleTypeEntity vehicleTypeEntity=new VehicleTypeEntity();
		when(repository.save(vehicleTypeEntity)).thenThrow(NullPointerException.class);
		service.insertVehicleType(vehicleTypeEntity);
	}
	@Test
	public void testgetVehicleTypes() throws Exception
	{
		Integer vehicleTypeId;
		List<VehicleTypeEntity>VehicleTypesList=new ArrayList<>();
		when(repository.findAll()).thenReturn(VehicleTypesList);
		List<VehicleTypeEntity>VehicleTypesLists=service.getVehicleTypes();
		assertNotNull(VehicleTypesLists);
	}
	@Test(expected = GoSmartException.class)
	public void testgetVehicleTypes_Exception() throws Exception
	{
		Integer vehicleTypeId=1;
		
		when(repository.findAll()).thenThrow(NullPointerException.class);
		service.getVehicleTypes();
	}
	@Test
	public void testGetVehicleType() throws Exception
	{
		Integer vehicleTypeId=1;
		Optional<VehicleTypeEntity> vehicleType=Mockito.any();
		when(repository.findById(vehicleTypeId)).thenReturn(vehicleType);
		List<VehicleTypeEntity> vehicleTypes=service.getVehicleTypes();
		assertNotNull(vehicleTypes);
		
	}
	@Test(expected = GoSmartException.class)
	public void testGetVehicleType_Exception() throws Exception
	{
		Integer vehicleTypeId=1;
		
		when(repository.findById(vehicleTypeId)).thenThrow(NullPointerException.class);
		service.getVehicleType(1);
		
	}
}
