package com.gosmart.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gosmart.repository.entity.VehicleEntity;
/*
 * <h2>VehicleService</h2>
 *  
 * */
@Service
public interface VehicleService {
	public Integer insertVehicle(VehicleEntity vehicleEntity);
	public List<VehicleEntity> getVehicles(Integer vehicleTypeId);
	public VehicleEntity getVehicles1(Integer vehicleId);
}
