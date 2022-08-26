package com.bpma.integrator.core.service.eventhub;

import org.springframework.stereotype.Component;

import com.bpma.integrator.core.domain.model.MessageEventHub;

@Component
public interface IEventHubService {
	void processMessage(MessageEventHub messageEventHub);
}