package com.facility.integrator.domain.model.facility;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class FacilityNaming implements Serializable {
	private static final long serialVersionUID = 1920287090146034623L;

	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idFacilityNaming;

	private String code;
	private String name;

}
