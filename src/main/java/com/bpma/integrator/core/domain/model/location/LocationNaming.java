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
public class LocationNaming implements Serializable {
	private static final long serialVersionUID = -4580423387444900610L;

	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idLocationNaming;

	private String code;
	private String name;
	private String version;
	private String effectiveFrom;
	private String effectiveTo;
	
	@ManyToOne
	private LocationBusinessObject locationBusinessObject;

}
