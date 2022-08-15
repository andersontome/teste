package com.facility.integrator.domain.model.facility;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.io.Serializable;

@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class FacilityChronology implements Serializable {
	private static final long serialVersionUID = -69172456777753940L;

	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
