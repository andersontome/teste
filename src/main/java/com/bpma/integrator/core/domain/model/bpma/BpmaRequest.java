package com.bpma.integrator.core.domain.model.bpma;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.bpma.integrator.core.application.domains.BpmaStatus;
import com.bpma.integrator.core.domain.model.ProcessData;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class BpmaRequest implements Serializable {
	private static final long serialVersionUID = 2438912095876854617L;

	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idBpmaRequest;
	
	private String businessPartnerId;
	private String companyName;
	private String stateRegistration;
	private Boolean stateRegistrationExempt;
	private String taxId;
	private String personType;
	private BpmaAddressesRequest[] facilityList;
	private Long[] vendorBusinessList;
	private ProcessData processData;
	private BpmaStatus status;
	private String globeStatusDescription;
}