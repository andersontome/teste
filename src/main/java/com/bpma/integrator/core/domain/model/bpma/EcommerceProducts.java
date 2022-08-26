package com.bpma.integrator.core.domain.model.bpma;

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
public class EcommerceProducts {

	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEcommerceChannels;
	
	private String version;
	private String productName;
	
	@ManyToOne
	private EcommerceChannels ecommerceChannels;
}
