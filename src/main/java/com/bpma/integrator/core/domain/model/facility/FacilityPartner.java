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
public class FacilityPartner implements Serializable {
	private static final long serialVersionUID = 2861166545687349756L;

//	@Id
//	@EqualsAndHashCode.Include
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long idFacilityPartner;
	
	@Id
	@EqualsAndHashCode.Include
	@SequenceGenerator(name = "seqfacilitypartner", sequenceName = "seqfacilitypartner", allocationSize = 1, initialValue = 9684) 
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqfacilitypartner")
	private Long idFacilityPartner;

	private String partnerNumber;
	private String partnerCode;

}
