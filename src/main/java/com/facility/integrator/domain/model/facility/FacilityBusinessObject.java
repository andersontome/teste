package com.facility.integrator.domain.model.facility;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class FacilityBusinessObject  implements Serializable {
	private static final long serialVersionUID = 110828100477053830L;

	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idFacilityBusinessObject;
	
	private String code;
	private String version;

	@JsonProperty("chronology")
	@OneToMany(mappedBy = "facilityBusinessObject", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<FacilityChronology> facilityChronology;

	@JsonProperty("facilityDetails")
	@OneToOne(cascade = CascadeType.ALL)
	private FacilityDetails facilityFacilityDetails;

	@JsonProperty("facilityStatus")
	@OneToMany(mappedBy = "facilityBusinessObject", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<FacilityStatus> facilityFacilityStatus;
	
	@JsonProperty("facilityCsCode")
	@OneToMany(mappedBy = "facilityBusinessObject", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<FacilityCsCode> facilityFacilityCsCode;
	
	@JsonProperty("facilityCompassCode")
	@OneToMany(mappedBy = "facilityBusinessObject", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<FacilityCompassCode> facilityFacilityCompassCode;

	@JsonProperty("extRefCodeType")
	@OneToMany(mappedBy = "facilityBusinessObject", cascade = CascadeType.ALL)
	private List<FacilityExtRefCodeType> facilityExtRefCodeType;

	private Boolean customerFacility;
	
}
