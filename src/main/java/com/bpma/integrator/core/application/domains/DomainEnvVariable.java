package com.bpma.integrator.core.application.domains;

public enum DomainEnvVariable {
	INTEGRATOR_EVENTHUB_GLOBE_KEYVAULT_SECRET("INTEGRATOR_EVENTHUB_GLOBE_KEYVAULT_SECRET",
			"ehauth.globe.business.partner.name.globe.IntegratorIntegrationService.listen.connstring.primary"),
	INTEGRATOR_AZURE_STORAGE_KEYVAULT_SECRET("INTEGTAROR_AZURE_STORAGE_KEYVAULT_SECRET","storage.primary.connectionstring");
	
	private String description;

	private String defaultValue;

	private DomainEnvVariable(String description, String defaultValue) {
		this.description = description;
		this.defaultValue = defaultValue;
	}

	public String getDescription() {
		return this.description;
	}

	public String getDefaultValue() {
		return defaultValue;
	}
}
