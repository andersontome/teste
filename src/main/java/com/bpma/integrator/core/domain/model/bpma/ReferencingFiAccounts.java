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
public class ReferencingFiAccounts implements Serializable {
	private static final long serialVersionUID = 7127650634017207029L;

	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idReferencingFiAccounts;
	
	private String version;
	private String territoryNumber;
	private String fiAccountNumber;
	private String effectiveDate;

	@ManyToOne
	private Addresses addresses;

}