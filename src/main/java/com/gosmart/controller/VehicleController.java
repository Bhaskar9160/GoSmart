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

import com.gosmart.constants.VehicleConstants;
import com.gosmart.repository.entity.VehicleEntity;
import com.gosmart.service.VehicleService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/api/v1")
public class VehicleController 
{
	@Autowired
	private VehicleService vehicleService;
	@PostMapping("/vehicle/save")
	public ResponseEntity<Integer> insertVehicle(@RequestBody VehicleEntity vehicleEntity)
	{
		log.info("{}-Controller insertVehicle() Started",VehicleConstants.VEHICLE);
		try {
			log.info("{}-Controller insertVehicle() saving Vehicle",VehicleConstants.VEHICLE);
			Integer vehicleId=vehicleService.insertVehicle(vehicleEntity);
			
			return new ResponseEntity<>(vehicleId,HttpStatus.CREATED);
		} catch (Exception e) {
			log.error("{}-Controller-insertVehicle()-exception occured-{}",VehicleConstants.VEHICLE,e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/vehicles/vehicle/{vehicleTypeId}")
	public ResponseEntity<List<VehicleEntity>> getVehicles(@PathVariable Integer vehicleTypeId)
	{
		log.info("{}-Controller getVehicle() Started",VehicleConstants.VEHICLE);
		try {
			log.info("{}-Controller getVehicle() saving Vehicle",VehicleConstants.VEHICLE);
			List<VehicleEntity> vehicles=vehicleService.getVehicles(vehicleTypeId);
			
			return new ResponseEntity<>(vehicles,HttpStatus.OK);
			
		} catch (Exception e) {
			log.error("{}-Controller-getVehicle()-exception occured-{}",VehicleConstants.VEHICLE,e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/vehicle/vehicles/{vehicleId}")
	public ResponseEntity<VehicleEntity> getVehicles1(@PathVariable Integer vehicleId)
	{
		log.info("{}-Controller getVehicle() Started",VehicleConstants.VEHICLE);
		try {
			log.info("{}-Controller getVehicles()getting Vehicles",VehicleConstants.VEHICLE);
			VehicleEntity vehicle=vehicleService.getVehicles1(vehicleId);
			return new ResponseEntity<>(vehicle,HttpStatus.OK);
		} catch (Exception e) {
			log.error("{}-Controller-getVehicle()-exception occured-{}",VehicleConstants.VEHICLE,e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
		
	}
	
}
