package com.bpma.integrator.core.domain.model.bpma;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class CommunicationDetails {

	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCommunicationDetails;
	
	private String version;
	private String communicationType;
	private String communicationValue;
	private Boolean isPreferred;
	
	@ManyToOne
	private Contacts contacts;
	
}
