package com.bpma.integrator.core.domain.model.city;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class CityBusinessObject implements Serializable {
	private static final long serialVersionUID = 601290217213283622L;

	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCityBusinessObject;

	private String code;
	private String version;
	private String validFrom;
	private String validTo;

	@JsonProperty("naming")
	@OneToMany(mappedBy = "cityBusinessObject", cascade = CascadeType.ALL)
	private List<CityNaming> cityNaming;

	private String cityCodeBR;
	private String country;
	private String state;

	@JsonProperty("location")
	@OneToMany(mappedBy = "cityBusinessObject", cascade = CascadeType.ALL)
	private List<CityLocation> cityLocation;

	@JsonProperty("postalCodeRange")
	@OneToMany(mappedBy = "cityBusinessObject", cascade = CascadeType.ALL)
	private List<CityPostalCodeRange> cityPostalCodeRange;

	@JsonProperty("compassCode")
	@OneToMany(mappedBy = "cityBusinessObject", cascade = CascadeType.ALL)
	private List<CityCompassCode> cityCompassCode;

	@JsonProperty("usCode")
	@OneToMany(mappedBy = "cityBusinessObject", cascade = CascadeType.ALL)
	private List<CityUsCode> cityUsCode;

}
