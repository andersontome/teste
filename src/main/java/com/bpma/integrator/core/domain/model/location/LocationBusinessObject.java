package com.bpma.integrator.core.domain.model.location;

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
public class LocationBusinessObject implements Serializable {
	private static final long serialVersionUID = 496847841576456719L;

	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idLocationBusinessObject;

	private String code;
	private Boolean isPort;
	private String version;
	private String validFrom;
	private String validTo;

	@JsonProperty("naming")
	@OneToMany(mappedBy = "locationBusinessObject", cascade = CascadeType.ALL)
	private List<LocationNaming> locationNaming;

	@JsonProperty("logHierarchy")
	@OneToMany(mappedBy = "locationBusinessObject", cascade = CascadeType.ALL)
	private List<LocationLogHierarchy> locationLogHierarchy;

	private String country;
	private String state;

	@OneToOne(cascade = CascadeType.ALL)
	private LocationDetails locationDetails;

	@OneToMany(mappedBy = "locationBusinessObject", cascade = CascadeType.ALL)
	private List<LocationCsCode> locationCsCode;

}
