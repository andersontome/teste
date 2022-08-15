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
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.io.Serializable;

@Data
@Entity
@Builder
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class FacilityExtRefCodeType implements Serializable {

	private static final long serialVersionUID = -7156618699323685338L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long idFacilityExtRefCodeType;

	@OneToOne
	@JoinColumn(name = "facility_business_object_id_facility_business_object")
	FacilityBusinessObject facilityBusinessObject;
}
