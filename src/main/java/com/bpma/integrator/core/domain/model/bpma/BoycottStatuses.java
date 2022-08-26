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
public class BoycottStatuses implements Serializable {
	private static final long serialVersionUID = -8527851103823706389L;

	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idBoycottStatuses;

	private String version;
	private String status;
	private String effectiveDate;
	private String expiryDate;

	@ManyToOne
	private BusinessObject businessObject;
}