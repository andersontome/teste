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
public class FacilityLogHierarchy implements Serializable {
	private static final long serialVersionUID = -3122201460835119014L;

//	@Id
//	@EqualsAndHashCode.Include
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long idFacilityLogHierarchy;
	
	@Id
	@EqualsAndHashCode.Include
	@SequenceGenerator(name = "seqfacilityloghierarchy", sequenceName = "seqfacilityloghierarchy", allocationSize = 1, initialValue = 9684) 
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqfacilityloghierarchy")
	private Long idFacilityLogHierarchy;
	
	private String parent;

}
