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
public class FacilityHour implements Serializable {
	private static final long serialVersionUID = -2672768732481769205L;

//	@Id
//	@EqualsAndHashCode.Include
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long idFacilityHour;
	
	@Id
	@EqualsAndHashCode.Include
	@SequenceGenerator(name = "seqfacilityhour", sequenceName = "seqfacilityhour", allocationSize = 1, initialValue = 9684) 
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqfacilityhour")
	private Long idFacilityHour;
	
	@JsonIgnore
	@ManyToOne
	private FacilityDetails facilityDetails;

}
