package com.facility.integrator.domain.repository.businessobject;

import com.facility.integrator.domain.model.facility.FacilityBusinessObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacilityBusinessObjectRepository extends JpaRepository<FacilityBusinessObject, Long>{
}
