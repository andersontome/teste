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
public class BillToParties implements Serializable {
	private static final long serialVersionUID = 6911005147732067443L;

	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idBillToParties;

	private String version;
	private String btPPartnerNumber;
	private Boolean isDefault;
	private String cityNumber;
	private Boolean isAutoBtP;
	private String effectiveDate;
	private String expiryDate;

	@ManyToOne
	private PartnerRoles partnerRoles;
}