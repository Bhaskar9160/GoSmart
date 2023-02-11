package com.gosmart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
/**
 * <h2>DesignationRepository</h2>
 * This from the maps to DesignationRepository
 * @author mansoor
 * */
import org.springframework.stereotype.Repository;

import com.gosmart.repository.entity.DesignationEntity;
@Repository
public interface DesignationRepository extends JpaRepository<DesignationEntity, Integer>{
	public DesignationEntity findByDesignationId(Integer designationId);
}
