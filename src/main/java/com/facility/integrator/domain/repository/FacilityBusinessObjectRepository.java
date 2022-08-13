package com.facility.integrator.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.facility.integrator.domain.model.facility.FacilityBusinessObject;

@Repository
public interface FacilityBusinessObjectRepository extends JpaRepository<FacilityBusinessObject, Long>{

}
