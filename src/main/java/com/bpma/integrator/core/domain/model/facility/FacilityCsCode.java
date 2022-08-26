package com.bpma.integrator.core.domain.model.facility;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class FacilityCsCode {
	
//	@Id
//	@EqualsAndHashCode.Include
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long idFacilityCsCode;
	
	@Id
	@EqualsAndHashCode.Include
	@SequenceGenerator(name = "seqfacilitycscode", sequenceName = "seqfacilitycscode", allocationSize = 1, initialValue = 9684) 
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqfacilitycscode")
	private Long idFacilityCsCode;

	@JsonIgnore
	@ManyToOne
	private FacilityBusinessObject facilityBusinessObject;

}
