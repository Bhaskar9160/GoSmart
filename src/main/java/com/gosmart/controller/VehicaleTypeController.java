package com.gosmart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gosmart.constants.VehicleTypeConstants;
import com.gosmart.repository.entity.VehicleTypeEntity;
import com.gosmart.service.VehicleTypeService;
import com.mysql.jdbc.log.Log;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/api/v1")
public class VehicaleTypeController {
	@Autowired
	private VehicleTypeService vehicleTypeService;
	
	@PostMapping("/vehicle/type/save")
	public ResponseEntity<Integer> insertVehicleType(@RequestBody VehicleTypeEntity vehicleTypeEntity)
	{
		
		log.info("{}-VehicaleTypeController insertUser()started",VehicleTypeConstants.VEHICLE_TYPE);

		try {
			log.info("{}-VehicaleTypeController insertUser()savingVehicleTypeDeatiles",VehicleTypeConstants.VEHICLE_TYPE);

			Integer vehicleTypeId=vehicleTypeService.insertVehicleType(vehicleTypeEntity);
			return new ResponseEntity<>(vehicleTypeId,HttpStatus.OK);
		} catch (Exception e) {
			log.error("{}-VehicaleTypeController insertuser()-{}",VehicleTypeConstants.VEHICLE_TYPE,e.getMessage());

			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/vehicle/type/vehicletypes")
	public ResponseEntity<List<VehicleTypeEntity>> getVehicleTypes()
	{
		
		log.info("{}-Controller getVehicleTypes()started",VehicleTypeConstants.VEHICLE_TYPE);

		try {
			log.info("{}-Controller getVehicleTypes()saving VehicleTypeDeatiles",VehicleTypeConstants.VEHICLE_TYPE);

			List<VehicleTypeEntity> vehicleTypes=vehicleTypeService.getVehicleTypes();
			return new ResponseEntity<>(vehicleTypes,HttpStatus.OK);
		} catch (Exception e) {
			log.error("{}-Controller exceptio occured()-{}",VehicleTypeConstants.VEHICLE_TYPE,e.getMessage());

			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/vehicle/type/vehicletype")
	public ResponseEntity<VehicleTypeEntity> getVehicleType(@RequestBody VehicleTypeEntity vehicleTypeEntity){
		
		log.info("{}-Controller getVehicleType()started",VehicleTypeConstants.VEHICLE_TYPE);
		
		try {
			
			log.info("{}-Controller getVehicleType()saving VehicleTypeDeatiles",VehicleTypeConstants.VEHICLE_TYPE);
			
			VehicleTypeEntity  vehicleTypes=vehicleTypeService.getVehicleType(vehicleTypeEntity.getVehicleTypeId());
			return new ResponseEntity(vehicleTypes, HttpStatus.OK);
			} catch (Exception e) {
				log.error("{}-Controller exceptio occured()-{}",VehicleTypeConstants.VEHICLE_TYPE,e.getMessage());
				
				
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
		
	}
	

}
