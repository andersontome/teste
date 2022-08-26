package com.bpma.integrator.core.domain.model.bpma;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class PartnerNames implements Serializable {
	private static final long serialVersionUID = 8138059764005102118L;

	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPartnerNames;

	private String version;
	private String partnerName1;
	private String approvalStatus;
	private String effectiveDate;
	private String expiryDate;

	@ManyToOne
	private BusinessObject businessObject;

}