package com.bpma.integrator.core.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bpma.integrator.core.domain.model.Facility;

@Repository
public interface FacilityRepository extends JpaRepository<Facility, Long>{

	List<Facility> findByFacilityBusinessObjectCode(String code);
}
