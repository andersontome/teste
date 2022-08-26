package com.bpma.integrator.core.domain.model.facility;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class FacilityDetails implements Serializable {
	private static final long serialVersionUID = -5342484295475552440L;
	
//	@Id
//	@EqualsAndHashCode.Include
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long idFacilityDetails;
	
	@Id
	@EqualsAndHashCode.Include
	@SequenceGenerator(name = "seqfacilitydetails", sequenceName = "seqfacilitydetails", allocationSize = 1, initialValue = 9684) 
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqfacilitydetails")
	private Long idFacilityDetails;
	
	@JsonProperty("access")
	@OneToMany(mappedBy = "facilityDetails", cascade = CascadeType.ALL)
	private List<FacilityAccess> facilityAccess;
	
	@JsonProperty("function")
	@OneToMany(mappedBy = "facilityDetails", cascade = CascadeType.ALL)
	private List<FacilityFunction> facilityFunction;
	
	@JsonProperty("facilityHour")
	@OneToMany(mappedBy = "facilityDetails", cascade = CascadeType.ALL)
	private List<FacilityHour> facilityHour;
	
}
