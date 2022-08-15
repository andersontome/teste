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
public class FacilityPartner implements Serializable {
	private static final long serialVersionUID = 2861166545687349756L;

	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idFacilityPartner;

	private String partnerNumber;
	private String partnerCode;

}
