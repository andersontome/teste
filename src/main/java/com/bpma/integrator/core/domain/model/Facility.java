package com.bpma.integrator.core.domain.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import com.bpma.integrator.core.domain.model.facility.FacilityBusinessObject;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Facility implements Serializable {
	private static final long serialVersionUID = -3451540038792597667L;

//	@Id
//	@EqualsAndHashCode.Include
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long idFacility;
	
	@Id
	@EqualsAndHashCode.Include
	@SequenceGenerator(name = "seqfacility", sequenceName = "seqfacility", allocationSize = 1, initialValue = 9684) 
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqfacility")
	private Long idFacility;

	@OneToOne(cascade = CascadeType.ALL)
	private ProcessData processData;

	@JsonProperty("businessObject")
	@OneToOne(cascade = CascadeType.ALL)
	private FacilityBusinessObject facilityBusinessObject;
	
}
