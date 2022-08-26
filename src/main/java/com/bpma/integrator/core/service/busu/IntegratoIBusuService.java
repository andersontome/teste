package com.bpma.integrator.core.service.busu;

import org.springframework.stereotype.Component;

@Component
public interface IntegratoIBusuService {
	void processData(String message);
}