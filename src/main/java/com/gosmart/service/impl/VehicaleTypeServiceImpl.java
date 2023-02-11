package com.gosmart.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gosmart.constants.VehicleTypeConstants;
import com.gosmart.exception.GoSmartException;
import com.gosmart.repository.VehicleTypeRepository;
import com.gosmart.repository.entity.VehicleTypeEntity;
import com.gosmart.service.VehicleTypeService;

import lombok.extern.slf4j.Slf4j;
/** 
 * <h2>VehicleTypeEntity
 * This Entity Class Map To VehicleTypeEntity
 * @author Teshadri
 * @version 1.0
 * @since 2022-12-17
 * */
@Service
@Slf4j
public class VehicaleTypeServiceImpl implements VehicleTypeService{
	@Autowired
	private VehicleTypeRepository vehicleTypeRepository;
	
	/**
	 * This method is used for the VehicleTypeEntity
	 * @param VehicleTypeEntity this is the parameter to is VehicleTypeExist 
	 * @return Integer returns VehicleTypeid */
	@Override
	public Integer insertVehicleType(VehicleTypeEntity vehicleTypeEntity) {
		Integer vehicleTypeId=0;
		log.info("{}-VehicaleTypeServiceImpl insertUser()started",VehicleTypeConstants.VEHICLE_TYPE);
		try {
			log.info("{}-VehicaleTypeServiceImpl insertUser()savingVehicleTypeDeatiles",VehicleTypeConstants.VEHICLE_TYPE);
			VehicleTypeEntity vehicleTypeEntity2=vehicleTypeRepository.save(vehicleTypeEntity);
			if(vehicleTypeEntity2!=null)
			{
				vehicleTypeId=vehicleTypeEntity2.getVehicleTypeId();
			}
		} catch (Exception e) {
			log.error("{}-VehicaleTypeServiceImpl insertuser()-{}",VehicleTypeConstants.VEHICLE_TYPE,e.getMessage());
			throw new GoSmartException(e.getMessage());
		}
		
		
		return vehicleTypeId;
	}

	@Override
	public List<VehicleTypeEntity> getVehicleTypes() {
		List<VehicleTypeEntity> vehicleTypes=null;
		try {
			log.info("{}-VehicaleTypeServiceImpl listUser()getVehicleTypesDeatiles",VehicleTypeConstants.VEHICLE_TYPE);
			vehicleTypes=vehicleTypeRepository.findAll();
			
		} catch (Exception e) {
			log.error("{}-VehicaleTypeServiceImpl listUser()-{}",VehicleTypeConstants.VEHICLE_TYPE,e.getMessage());
			throw new GoSmartException(e.getMessage());
		}
		return vehicleTypes;
	}

	@Override
	public VehicleTypeEntity getVehicleType(Integer vehicleTypeId) {
		VehicleTypeEntity vehicleType=null;
		try {
			log.info("{}-VehicaleTypeServiceImpl listUser()getVehicleTypeDeatiles",VehicleTypeConstants.VEHICLE_TYPE);
			Optional<VehicleTypeEntity> opt=vehicleTypeRepository.findById(vehicleTypeId);
			if(opt!=null)
			{
				vehicleType=opt.get();
			}
			
			
		} catch (Exception e) {
			log.error("{}-VehicaleTypeServiceImpl listUser()-{}",VehicleTypeConstants.VEHICLE_TYPE,e.getMessage());
			throw new GoSmartException(e.getMessage());
		}
		return vehicleType;
	}
	

}
