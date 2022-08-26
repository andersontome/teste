package com.bpma.integrator.core.application.domains;

public enum BpmaGlobeStatus {
	OPENED("OPENED"), CANCELLED("CANCELLED"), WAITLISTED("WAITLISTED"), APPROVED("APPROVED"), REJECTED("REJECTED");

	private String description;

	private BpmaGlobeStatus(String description) {
		this.description = description;
	}

	public String getDescription() {
		return this.description;
	}
}