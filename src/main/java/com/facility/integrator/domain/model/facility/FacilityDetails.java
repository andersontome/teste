package com.facility.integrator.domain.model.facility;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.io.Serializable;

@Data
@Entity
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FacilityDetails implements Serializable {

	private static final long serialVersionUID = -5342484295475552440L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long idFacilityDetails;

	@OneToOne(cascade = CascadeType.PERSIST, mappedBy = "facilityDetails")
	FacilityAccess facilityAccess;

	@OneToOne(cascade = CascadeType.PERSIST, mappedBy = "facilityDetails")
	FacilityFunction facilityFunction;

	@OneToOne(cascade = CascadeType.PERSIST, mappedBy = "facilityDetails")
	FacilityHour facilityHour;

	public void bindAggregates(
			final FacilityAccess facilityAccess,
			final FacilityFunction facilityFunction,
			final FacilityHour facilityHour) {
		this.facilityAccess = facilityAccess;
		this.facilityFunction = facilityFunction;
		this.facilityHour = facilityHour;
	}
}
