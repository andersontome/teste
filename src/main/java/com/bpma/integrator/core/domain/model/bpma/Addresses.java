package com.bpma.integrator.core.domain.model.bpma;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Addresses implements Serializable {
	private static final long serialVersionUID = -366697553320756460L;

	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAddresses;

	private String version;
	private String functionAddressType;
	private Boolean isDefaultAddress;
	private Boolean isCustomer;
	private Boolean isVendor;
	
	@OneToMany(mappedBy = "addresses", cascade = CascadeType.ALL)
	private List<AddressesOverviews> addressOverviews;
	
	private transient List<String> formattedAddress;
	
	@OneToMany(mappedBy = "addresses", cascade = CascadeType.ALL)
	private List<Contacts> contacts;
	
	@OneToMany(mappedBy = "addresses", cascade = CascadeType.ALL)
	private List<ReferencingFiAccounts> referencingFiAccounts;

	@ManyToOne
	private BusinessObject businessObject;

}