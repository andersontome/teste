package com.bpma.integrator.core.domain.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ProcessData implements Serializable {
	private static final long serialVersionUID = 776620290485943540L;

//	@Id
//	@EqualsAndHashCode.Include
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long idProcessData;
	
	@Id
	@EqualsAndHashCode.Include
	@SequenceGenerator(name = "seqprocessdata", sequenceName = "seqprocessdata", allocationSize = 1, initialValue = 9684) 
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqprocessdata")
	private Long idProcessData;

	private String changeType;
	private String versionNumber;

}
