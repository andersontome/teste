package com.bpma.integrator.core.application.domains;

public enum DomainReturnCode {

	FAILURE_COMUNICATION_GET_TOKEN_MICROSOFT("FAILURE COMUNICATION GET TOKEN MICROSOFT", "Failed to communicate with microsoft service");

	private String code;
	private String description;

	private DomainReturnCode(String code, String description) {
		this.setCode(code);
		this.setDescription(description);
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}