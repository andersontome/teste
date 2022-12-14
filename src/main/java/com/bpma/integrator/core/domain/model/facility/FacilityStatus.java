package com.bpma.integrator.core.domain.model.facility;

import java.io.Serializable;

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
public class FacilityStatus implements Serializable {
	private static final long serialVersionUID = 6434500078541510842L;

//	@Id
//	@EqualsAndHashCode.Include
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long idFacilityStatus;

	@Id
	@EqualsAndHashCode.Include
	@SequenceGenerator(name = "seqfacilitystatus", sequenceName = "seqfacilitystatus", allocationSize = 1, initialValue = 9684) 
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqfacilitystatus")
	private Long idFacilityStatus;
	
	private String status;
	private String effectiveFrom;
	private String effectiveTo;
	private String version;

	@JsonIgnore
	@ManyToOne
	private FacilityBusinessObject facilityBusinessObject;
}
