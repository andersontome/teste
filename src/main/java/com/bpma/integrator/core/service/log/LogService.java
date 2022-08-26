package com.bpma.integrator.core.service.log;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.intercab.log.core.service.MonitoringService;

@Service
public class LogService extends MonitoringService implements ILogService {

	@Autowired
	private Environment env;

	@Async("threadPoolTaskExecutor")
	@Override
	public void save(String errorId, String errorTitle, String errorMessage, StackTraceElement[] stackTrace, Object moreDetails) {
		String evironment = this.env.getProperty("server.environment");
		String apiId = this.env.getProperty("api.id");
		String apiName = this.env.getProperty("api.name");


	}
}