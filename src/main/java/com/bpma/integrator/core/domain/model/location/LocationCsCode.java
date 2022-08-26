package com.bpma.integrator.core.domain.model.location;

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
public class LocationCsCode implements Serializable {
	private static final long serialVersionUID = -2218378185447565582L;

	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idLocationCsCode;

	private String ecosPortCode;
	private String effectiveFrom;
	private String effectiveTo;
	private String version;

	@ManyToOne
	private LocationBusinessObject locationBusinessObject;

}
