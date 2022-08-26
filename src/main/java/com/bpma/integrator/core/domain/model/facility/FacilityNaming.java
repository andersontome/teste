package com.bpma.integrator.core.domain.model.facility;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class FacilityNaming implements Serializable {
	private static final long serialVersionUID = 1920287090146034623L;

//	@Id
//	@EqualsAndHashCode.Include
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long idFacilityNaming;

	@Id
	@EqualsAndHashCode.Include
	@SequenceGenerator(name = "seqfacilitynaming", sequenceName = "seqfacilitynaming", allocationSize = 1, initialValue = 9684) 
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqfacilitynaming")
	private Long idFacilityNaming;
	
	private String code;
	private String name;

}
