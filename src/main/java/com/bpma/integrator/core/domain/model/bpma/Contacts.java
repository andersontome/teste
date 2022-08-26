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
public class Contacts implements Serializable {
	private static final long serialVersionUID = -6379725197197996081L;

	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idContacts;
	
	private String version;
	private String businessFunction;
	private String personType;
	private String personTitle;
	private String firstName;
	private String lastName;
	private String remark;
	private String effectiveDate;
	private String expiryDate;
	
	@OneToMany(mappedBy = "contacts", cascade = CascadeType.ALL)
	private List<CommunicationDetails> communicationDetails;

	@ManyToOne
	private Addresses addresses;
}