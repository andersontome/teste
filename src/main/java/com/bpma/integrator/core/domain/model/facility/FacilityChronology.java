package com.bpma.integrator.core.domain.model.facility;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class FacilityChronology implements Serializable {
	private static final long serialVersionUID = -69172456777753940L;

//	@Id
//	@EqualsAndHashCode.Include
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long idFacilityChronology;
	
	@Id
	@EqualsAndHashCode.Include
	@SequenceGenerator(name = "seqfacilitychronology", sequenceName = "seqfacilitychronology", allocationSize = 1, initialValue = 9684) 
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqfacilitychronology")
	private Long idFacilityChronology;

	private String effectiveFrom;
	private String effectiveTo;
	private String version;

	@JsonProperty("naming")
	@OneToOne(cascade = CascadeType.ALL)
	private FacilityNaming facilityNaming;

	@JsonProperty("logHierarchy")
	@OneToOne(cascade = CascadeType.ALL)
	private FacilityLogHierarchy facilityLogHierarchy;

	@JsonProperty("partner")
	@OneToOne(cascade = CascadeType.ALL)
	private FacilityPartner facilityPartner;

	@JsonIgnore
	@ManyToOne
	private FacilityBusinessObject facilityBusinessObject;

}
