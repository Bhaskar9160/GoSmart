package com.gosmart.service;

import java.util.List;

import com.gosmart.repository.entity.VehicleTypeEntity;

public interface VehicleTypeService {
	public Integer insertVehicleType(VehicleTypeEntity vehicleTypeEntity);
	public List<VehicleTypeEntity> getVehicleTypes();
	public VehicleTypeEntity getVehicleType(Integer vehicleTypeId);

}
