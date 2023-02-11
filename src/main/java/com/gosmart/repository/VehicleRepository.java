package com.gosmart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gosmart.repository.entity.VehicleEntity;
@Repository
public interface VehicleRepository extends JpaRepository<VehicleEntity, Integer>{
	public List<VehicleEntity> findAllByVehicleTypeId(Integer vehicleTypeId);
	public VehicleEntity findByVehicleId(Integer vehicleId);
	
}
