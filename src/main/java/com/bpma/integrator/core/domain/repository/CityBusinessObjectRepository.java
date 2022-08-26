package com.bpma.integrator.core.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bpma.integrator.core.domain.model.city.CityBusinessObject;

public interface CityBusinessObjectRepository extends JpaRepository<CityBusinessObject, Long>{

}
