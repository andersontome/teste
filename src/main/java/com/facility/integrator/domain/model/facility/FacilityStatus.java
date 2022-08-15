package com.facility.integrator.domain.model.facility;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.io.Serializable;

@Data
@Entity
@Builder
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class FacilityStatus implements Serializable {
	private static final long serialVersionUID = 6434500078541510842L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idFacilityStatus;

	@Column
	private String status;

	@Column
	private String effectiveFrom;

	@Column
	private String effectiveTo;

	@Column
	private String version;

	@OneToOne
	@JoinColumn(name = "facility_business_object_id_facility_business_object")
	private FacilityBusinessObject facilityBusinessObject;
}
