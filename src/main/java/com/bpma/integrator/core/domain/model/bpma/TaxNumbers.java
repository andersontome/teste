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
public class TaxNumbers implements Serializable {
	private static final long serialVersionUID = -2700752441462374746L;

	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTaxNumbers;

	private String version;
	private String taxCode;
	private String taxNumber;

	@ManyToOne
	private BusinessObject businessObject;
}