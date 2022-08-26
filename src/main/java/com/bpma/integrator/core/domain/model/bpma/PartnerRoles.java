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
public class PartnerRoles implements Serializable {
	private static final long serialVersionUID = 5615665042109675928L;

	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPartnerRoles;

	private String version;
	private String partnerRole;

	@OneToMany(mappedBy = "partnerRoles", cascade = CascadeType.ALL)
	private List<PartnerFunctions> partnerFunctions;

	@OneToMany(mappedBy = "partnerRoles", cascade = CascadeType.ALL)
	private List<CommunicationPreferences> communicationPreferences;

	@OneToMany(mappedBy = "partnerRoles", cascade = CascadeType.ALL)
	private List<BillToParties> billToParties;

	@OneToMany(mappedBy = "partnerRoles", cascade = CascadeType.ALL)
	private List<OperatorCodes> operatorCodes;

	@ManyToOne
	private BusinessObject businessObject;

}