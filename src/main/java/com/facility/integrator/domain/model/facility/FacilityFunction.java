package com.facility.integrator.domain.model.facility;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.io.Serializable;

@Data
@Entity
@Builder
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class FacilityFunction implements Serializable {

	private static final long serialVersionUID = 3518300475463132418L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long idFacilityFunction;

	@Column
	String facilityFunctionType;

	@OneToOne
	@JoinColumn(name = "facility_details_id_facility_details")
	FacilityDetails facilityDetails;
}
