package com.bpma.integrator.core.domain.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.bpma.integrator.core.domain.model.location.LocationBusinessObject;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Location implements Serializable {
	private static final long serialVersionUID = -6763920340996882993L;

	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idLocation;

	@OneToOne(cascade = CascadeType.ALL)
	private ProcessData processData;

	@OneToOne(cascade = CascadeType.ALL)
	private LocationBusinessObject businessObject;

}
