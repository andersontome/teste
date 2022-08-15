package com.facility.integrator.domain.model.facility;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Data
@Entity
@Builder
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class FacilityCompassCode {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long idFacilityCompassCode;

	@OneToOne
	@JoinColumn(name = "facility_business_object_id_facility_business_object")
	FacilityBusinessObject facilityBusinessObject;
}
