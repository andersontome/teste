package com.bpma.integrator.core.domain.model.city;

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
public class CityUsCode implements Serializable {
	private static final long serialVersionUID = -9141010206941248419L;

	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCityCsCode;
	
	private String code;
	private String version;
	private String effectiveFrom;
	private String effectiveTo;

	@ManyToOne
	private CityBusinessObject cityBusinessObject;

}
