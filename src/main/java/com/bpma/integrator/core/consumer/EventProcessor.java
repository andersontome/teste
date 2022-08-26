package com.bpma.integrator.core.consumer;

import java.nio.charset.Charset;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.bpma.integrator.core.application.domains.Globe;
import com.bpma.integrator.core.domain.model.Bpma;
import com.bpma.integrator.core.domain.model.City;
import com.bpma.integrator.core.domain.model.Facility;
import com.bpma.integrator.core.domain.model.Location;
import com.bpma.integrator.core.domain.model.MessageEventHub;
import com.bpma.integrator.core.domain.service.BpmaService;
import com.bpma.integrator.core.domain.service.CityService;
import com.bpma.integrator.core.domain.service.FacilityService;
import com.bpma.integrator.core.domain.service.LocationService;
import com.bpma.integrator.core.service.log.ILogService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microsoft.azure.eventhubs.EventData;
import com.microsoft.azure.eventprocessorhost.CloseReason;
import com.microsoft.azure.eventprocessorhost.IEventProcessor;
import com.microsoft.azure.eventprocessorhost.PartitionContext;

@Component
public class EventProcessor implements IEventProcessor {

	private static final String EVENT_PROCESSOR_PARTITION = "EVENT_PROCESSOR: Partition ";
	private static final Logger LOGGER = LogManager.getLogger(EventProcessor.class);

	@Autowired
	private CityService cityService;

	@Autowired
	private FacilityService facilityService;

	@Autowired
	private LocationService locationService;
	
	@Autowired
	private BpmaService bpmaService;

	@Value("error.id")
	private String errorId;

	@Value("${integrador.eventhub.globe.properties.filter}")
	private String filter;

	private final ILogService logService;


	EventProcessor(ILogService logService) {
		this.logService = logService;
	}

	@Override
	public void onOpen(PartitionContext context) throws Exception {
		LOGGER.info(EVENT_PROCESSOR_PARTITION + context.getPartitionId() + " is opening");
	}

	@Override
	public void onClose(PartitionContext context, CloseReason reason) throws Exception {
		LOGGER.info(
				EVENT_PROCESSOR_PARTITION + context.getPartitionId() + " is closing for reason " + reason.toString());
	}

	@Override
	public void onError(PartitionContext context, Throwable error) {
		StringBuilder sb = new StringBuilder(100);
		sb.append(EVENT_PROCESSOR_PARTITION).append(context.getPartitionId()).append(" onError: ")
				.append(error.toString());
		LOGGER.error(sb.toString());
		this.logService.save(this.errorId, error.toString(), sb.toString(), error.getStackTrace(), null);
	}

	@Override
	public void onEvents(PartitionContext context, Iterable<EventData> events) {
		LOGGER.info(EVENT_PROCESSOR_PARTITION + context.getPartitionId() + " got event batch");

		for (EventData receivedEvent : events) {
			LOGGER.info(EVENT_PROCESSOR_PARTITION + context.getPartitionId() + " checkpointing at "
					+ receivedEvent.getSystemProperties().getOffset() + ","
					+ receivedEvent.getSystemProperties().getSequenceNumber());
			final Optional<MessageEventHub> message = parseEventHubMessage(receivedEvent);
			
			if (message.isPresent()) {
				
				ObjectMapper objectMapper = new ObjectMapper();

				objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

				try {

					String eventName = receivedEvent.getProperties().get("eventName").toString();
					
					if (eventName.equals(Globe.CITY.getDescricao())) {

						City city = objectMapper.readValue(message.get().getMessage(), City.class);
						
						cityService.save(city);

					} else if (eventName.equals(Globe.FACILITY.getDescricao())) {
						
						Facility facility = objectMapper.readValue(message.get().getMessage(), Facility.class);

						facilityService.save(facility);
						
					} else if (eventName.equals(Globe.LOCATION.getDescricao())) {
						
						Location location = objectMapper.readValue(message.get().getMessage(), Location.class);
						
						locationService.save(location);
						
					} else if(eventName.equals(Globe.BPMA.getDescricao()))  {
						
						Bpma bpma = objectMapper.readValue(message.get().getMessage(), Bpma.class);
						
						bpmaService.save(bpma);
						
					}

				} catch (JsonMappingException e) {
					e.printStackTrace();
				} catch (JsonProcessingException e) {
					e.printStackTrace();
				}
			}
			
			LOGGER.info("Mensagem recebida: {}", message.map(m -> m.getMessage()).orElse("mensagem veio nula"));
		}
	}

	private Optional<MessageEventHub> parseEventHubMessage(final EventData receivedEvent) {
		if (receivedEvent.getBytes() != null) {
			String message = new String(receivedEvent.getBytes(), Charset.defaultCharset());
			return Optional.of(new MessageEventHub("Test", message));
		}

		return Optional.empty();
	}
}