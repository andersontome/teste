package com.bpma.integrator.core.domain.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.bpma.integrator.core.domain.model.bpma.BusinessObject;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Bpma implements Serializable {
	private static final long serialVersionUID = -2476813715197739331L;

	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idBusinessPartner;

	@OneToOne(cascade = CascadeType.ALL)
	private ProcessData processData;

	@OneToOne(cascade = CascadeType.ALL)
	private BusinessObject businessObject;

}
