package com.gosmart.repository.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
/** 
 * <h2>VehicleTypeEntity
 * This Entity Class Map To VehicleTypeEntity
 * @author Teshadri
 * @version 1.0
 * @since 2022-12-17
 * */
@Entity
@Table(name="VEHICLETYPEENTITY_TL")
@Data
public class VehicleTypeEntity {
	
	//primary key
	@Id
	@Column(name="VEHICLE_TYPE_ID")
	@GeneratedValue
	//name of the vehicle id
	private Integer vehicleTypeId;
	@Column(name="VEHICLE_NAME")
	//name of the vehicle name
	private String vehicleName;
	//name of the vehicle created by
	@Column(name="VEHICLE_CREATED_BY")
	private Integer vehicleCreatedBy;
	//name of the vehicle update by
	@Column(name="VEHICLE_UPDATE_BY")
	private Integer vehicleUpdateBy;
	//name of the vehicle created on
	@Column(name="VEHICLE_CREATED_ON")
	private Date  vehicleCreatedOn;
	//name of the vehicle update on
	@Column(name="VEHICLE_UPDATE_ON")
	private Date  vehicleUpdateOn;
	

}
