package com.bpma.integrator.core.domain.model.bpma;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class BusinessObject implements Serializable {
	private static final long serialVersionUID = 4775289075927446068L;

	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idBusinessObject;
	
	private String code;
	private String version;
	private String partnerShortName;
	private String cmdId;
	private String alias;
	private String remark;
	private Boolean isEquipmentCustomer;
	private Boolean isKYCChecked;
	private String mainTelephoneNo;
	private String mainFaxNo;
	private String mainEmailAddress;
	private Boolean isSuspended;

	@OneToMany(mappedBy = "businessObject", cascade = CascadeType.ALL)
	private List<PartnerNames> partnerNames;

	@OneToMany(mappedBy = "businessObject", cascade = CascadeType.ALL)
	private List<BoycottStatuses> boycottStatuses;

	@OneToMany(mappedBy = "businessObject", cascade = CascadeType.ALL)
	private List<PartnerRoles> partnerRoles;

	@OneToMany(mappedBy = "businessObject", cascade = CascadeType.ALL)
	private List<TaxNumbers> taxNumbers;
	
	@OneToMany(mappedBy = "businessObject", cascade = CascadeType.ALL)
	private List<Addresses> addresses;
	
	private Boolean isTaxFreeZoneAddress;
	
	@OneToMany(mappedBy = "businessObject", cascade = CascadeType.ALL)
	private List<FiAccounts> fiAccounts;
	
	@OneToMany(mappedBy = "businessObject", cascade = CascadeType.ALL)
	private List<EcommerceChannels> ecommerceChannels;
	
}