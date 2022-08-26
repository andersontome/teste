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
public class FacilityAccess implements Serializable {
	private static final long serialVersionUID = 5865412535799833696L;

//	@Id
//	@EqualsAndHashCode.Include
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long idFacilityAccess;

	@Id
	@EqualsAndHashCode.Include
	@SequenceGenerator(name = "seqfacilityaccess", sequenceName = "seqfacilityaccess", allocationSize = 1, initialValue = 9684) 
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqfacilityaccess")
	private Long idFacilityAccess;
	
	private String accessMode;
	private String version;

	@JsonIgnore
	@ManyToOne
	private FacilityDetails facilityDetails;

}
