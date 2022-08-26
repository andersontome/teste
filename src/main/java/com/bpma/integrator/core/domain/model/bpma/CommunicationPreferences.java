package com.bpma.integrator.core.domain.model.bpma;

import java.io.Serializable;

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
public class CommunicationPreferences implements Serializable {
	private static final long serialVersionUID = -2785621866684565102L;

	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCommunicationPreferences;
	
	private String version;
	private String functionActivityType;
	private String communicationType;
	private String communicationNumber;
	private Boolean isPreferred;
	
	@ManyToOne
	private PartnerRoles partnerRoles;
}