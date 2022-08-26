package com.bpma.integrator.core.consumer;

import javax.annotation.PostConstruct;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import com.bpma.integrator.IntegratorB2uBpmaApplication;
import com.bpma.integrator.core.service.log.ILogService;
import com.microsoft.azure.eventhubs.ConnectionStringBuilder;

@ExtendWith(MockitoExtension.class)
@ActiveProfiles("test")
@ContextConfiguration(classes = IntegratorB2uBpmaApplication.class)
public class EventHubConsumerTest {

	@InjectMocks
    private EventHubConsumer eventHubConsumer;

	@Mock
    private EventProcessorFactory eventProcessorFactory;

	@Mock
    private ILogService logService;

	@Value("${integrador.eventhub.globe.connstring}")
	private String connString;

	@Value("${integrador.eventhub.globe.consumergroupname}")
	private String consumerGroupName;

	@Value("${integrador.eventhub.globe.hostnameprefix}")
	private String hostNamePrefix;

	@Value("${integrador.eventhub.globe.storagecontainername}")
	private String storageContainerName;

	@Value("${integrador.eventhub.globe.storageconnstring}")
	private String storageConnectionString;
	
	ConnectionStringBuilder connStrBuilder;
	
    @PostConstruct
    public void setUpTest() {
        connStrBuilder = new ConnectionStringBuilder(connString);
    }

    @Test
    public void buildEventProcessorHostSuccessful() {

    }

    @Test
    public void startListenerEventHubSuccessful() {

    }
}