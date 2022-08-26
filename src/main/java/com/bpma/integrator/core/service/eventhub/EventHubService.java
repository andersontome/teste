package com.bpma.integrator.core.service.eventhub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.bpma.integrator.core.domain.model.MessageEventHub;
import com.bpma.integrator.core.service.busu.IntegratoIBusuService;

@Service
public class EventHubService implements IEventHubService {
	@Autowired
	private Environment env;

	@Autowired
	IntegratoIBusuService businessPartnerService;

	@Override
	public void processMessage(MessageEventHub messageEventHub) {
//		String globeBusinessPartner = KeyVaultUtils.getSecretValue(this.env, "eventhub.globe.businespartnes.name");
		String globeBusinessPartner = "eventhub.globe.businespartnes.name";


		if (globeBusinessPartner.equals(messageEventHub.getEventName())) {
			this.businessPartnerService.processData(messageEventHub.getMessage());
		}
	}
}