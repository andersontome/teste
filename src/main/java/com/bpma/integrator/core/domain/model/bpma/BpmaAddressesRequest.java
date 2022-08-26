package com.bpma.integrator.core.domain.model.bpma;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class BpmaAddressesRequest implements Serializable {
	private static final long serialVersionUID = -7349149959835478595L;

	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idBpmaAddressesRequest;
	
	private String busuCityId;
	private String busuCityName;
	private String busuStateId;
	private String address;
	private String number;
	private String zipCode;
	private String district;
	private String complement;
	private Boolean mainFacility;
	private String globeExpiryDate;
	private String globeSfc;
	private String globeBPnumber;
	private String globeStatusDescription;
	private String source;

}