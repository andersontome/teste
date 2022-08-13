package com.facility.integrator.domain.model.facility;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class FacilityFunction implements Serializable {
	private static final long serialVersionUID = 3518300475463132418L;

	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idFacilityFunction;
	
	private String facilityFunctionType;
	
	@JsonIgnore
	@ManyToOne
	private FacilityDetails facilityDetails;

}