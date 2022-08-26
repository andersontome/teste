package com.bpma.integrator.core.domain.model.bpma;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class BpmaCommunicationDetails implements Serializable {
	private static final long serialVersionUID = 8288630342741064367L;

	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idBpmaCommunicationDetails;
	
	private String communicationType;
	private String communicationValue;
	private Boolean isPreferred;
	private String version;

}