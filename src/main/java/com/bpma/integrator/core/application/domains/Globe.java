package com.bpma.integrator.core.application.domains;

import lombok.Getter;

@Getter
public enum Globe {

	FACILITY("Globe-Facility"),
	LOCATION("Globe-Location"),
	CITY("Globe-City"),
	BPMA("Globe-BusinessPartner");
	
	private String descricao;
	
	Globe(String descricao) {
		this.descricao = descricao;
	}
	
}
