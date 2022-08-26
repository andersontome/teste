package com.bpma.integrator.core.domain.model.bpma;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class EcommerceChannels implements Serializable {
	private static final long serialVersionUID = -5560334159575394521L;

	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEcommerceChannels;
	
	private String version;
	private String channelName;
	private String channelCode;
	private String isPreferred;
	private String territoryNumber;
	private String fiAccountNumber;

	@OneToMany(mappedBy = "ecommerceChannels", cascade = CascadeType.ALL)
	private List<EcommerceProducts> ecommerceProducts;
	
	@ManyToOne
	private BusinessObject businessObject;
}