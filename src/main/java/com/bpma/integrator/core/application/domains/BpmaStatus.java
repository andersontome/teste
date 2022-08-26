package com.bpma.integrator.core.application.domains;

public enum BpmaStatus {
	A("A", "Active"), I("I", "Inactive"), E("E", "Excluded"), P("P", "Pending");

	private String code;
	private String description;

	private BpmaStatus(String code, String description) {
		this.code = code;
		this.description = description;
	}

	public String getCode() {
		return this.code;
	}

	public String getDescription() {
		return this.description;
	}
}