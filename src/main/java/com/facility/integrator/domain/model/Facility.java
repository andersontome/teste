package com.facility.integrator.domain.model;

import com.facility.integrator.domain.model.facility.FacilityBusinessObject;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.CascadeType;
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
public class Facility implements Serializable {

	private static final long serialVersionUID = -3451540038792597667L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long idFacility;

	@OneToOne( cascade = CascadeType.ALL)
	@JoinColumn(name = "process_data_id_process_data")
	ProcessData processData;

	@OneToOne
	@JoinColumn(name = "facility_business_object_id_facility_business_object")
	FacilityBusinessObject facilityBusinessObject;
}
