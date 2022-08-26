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
public class FiAccounts implements Serializable {
	private static final long serialVersionUID = -1972099381774346857L;

	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idFiAccounts;
	
	private String version;
	private String territoryNumber;
	private String fiAccountNumber;
	private String isNonGlobe;
	private String effectiveDate;
	private String expiryDate;
	private String partnerRole;

	@ManyToOne
	private BusinessObject businessObject;
}