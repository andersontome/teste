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
public class AddressesOverviews implements Serializable {
	private static final long serialVersionUID = 3114984609897507034L;

	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAddressesOverviews;

	private String version;
	private String status;
	private String effectiveDate;
	private String expiryDate;
	private String addressType;
	private String streetName1;
	private String streetName2;
	private String streetNumber;
	private String postalCode;
	private String cityNumber;
	private String stateNumber;
	private String countryNumber;
	private String district;

	@ManyToOne
	private Addresses addresses;

}