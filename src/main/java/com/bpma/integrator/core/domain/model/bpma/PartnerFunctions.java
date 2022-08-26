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
public class PartnerFunctions implements Serializable {
	private static final long serialVersionUID = 4293876004963179960L;

	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPartnerFunctions;

	private String version;
	private String functionTypeCode;
	private String approvalStatus;
	private String effectiveDate;
	private String expiryDate;

	@ManyToOne
	private PartnerRoles partnerRoles;

}