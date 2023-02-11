package com.gosmart.repository.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
/**
 * <h2>DesignationEntity</h2>
 * This entity class maps to designation_tl
 * @author mansoor
 * @version 1.0
 * @since 2022-12-17
 * 
 * */
@Entity
@Table(name="DESIGNATION_TL")
@Data

public class DesignationEntity {
	//primary key
	@Id
	@GeneratedValue
	@Column(name="DESIGNATION_ID")
	private Integer designationId;
	@Column(name="DESIGNATION_NAME")
	//Name of the designation
	private String designationName;
	@Column(name="DESIGNATION_STATUS")
	//Status of the designation
	private String designationStatus;
	@Column(name="DESIGNATION_DESCRIPTION")
	//Description of the designation
	private String designationDescription;
	@Column(name="DESIGNATION_CREATED_ON")
	//CreatedOn of the designation
	private Date designationCreatedOn;
	@Column(name="DESIGNATION_CREATED_BY")
	//CreatedBy of the designation
	private Integer designationCreatedBy;
	@Column(name="DESIGNATION_UPDATED_ON")
	//UpdatedOn of the designation
	private Date designationUpdatedOn;
	@Column(name="DESIGNATION_UPDATED_BY")
	//UpdatedBy of the designation
	private Integer designationUpdatedBy;
}
