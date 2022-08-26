package com.bpma.integrator.core.domain.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.bpma.integrator.core.domain.model.city.CityBusinessObject;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class City implements Serializable {
	private static final long serialVersionUID = 8165534872621284083L;

	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCity;

	@OneToOne(cascade = CascadeType.ALL)
	private ProcessData processData;

	@JsonProperty("businessObject")
	@OneToOne(cascade = CascadeType.ALL)
	private CityBusinessObject cityBusinessObject;

}
