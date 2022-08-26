package com.bpma.integrator.core.service.busu;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.bpma.integrator.core.application.domains.DomainStatus;
import com.bpma.integrator.core.domain.log.model.BusinessPartnerLog;
import com.bpma.integrator.core.service.log.ILogService;
import com.google.gson.JsonSyntaxException;
import com.intercab.log.core.model.LogMoreDetails;

@Service
public class IntegratorBusuService implements IntegratoIBusuService {
	private final Logger logger = LoggerFactory.getLogger(IntegratorBusuService.class);

	@Autowired
	private ILogService logService;

	@Autowired
	private Environment env;

	@Override
	public void processData(String message) {
		this.logger.info("Globe-Business-Partner - Process Message");

		BusinessPartnerLog businessPartnerLog = new BusinessPartnerLog(new Date(), message);
//		Integer countryCod = Integer.valueOf("country.cod.brazil");

		try {
//			Gson gson = new Gson();
		//	BusinessPartnerEventHub businessPartner = gson.fromJson(message, BusinessPartnerEventHub.class);
		//	businessPartnerLog.setAction(businessPartner.getProcessData().getChangeType());

	//		this.prepareToSend(businessPartner, businessPartnerLog, countryCod);
			this.logger.info("Globe-Business-Partner - Integrated Message");
		} catch (JsonSyntaxException error) {
			List<LogMoreDetails> errorList = new ArrayList<LogMoreDetails>();
			errorList.add(new LogMoreDetails(DomainStatus.UNPROCESSED.getDescription(), error.getMessage()));

			businessPartnerLog.setError(errorList);
			businessPartnerLog.setStatus(DomainStatus.UNPROCESSED.getDescription());

			this.logService.save(this.env.getProperty("error.id"), DomainStatus.UNPROCESSED.getDescription(), DomainStatus.UNPROCESSED.getDescription(), error.getStackTrace(), businessPartnerLog);
			this.logger.info("Globe-Business-Partner - Exception found and sent to CosmosDB - {}", businessPartnerLog.getError());
		}
	}

//	private void prepareToSend(BusinessPartnerEventHub businessPartnerEventHub, BusinessPartnerLog log, Integer countryCod) {
//		try {
//		//	List<DomainPartnerRole> partnerRoleList = BusinessPartnerValidator.partnerRole(businessPartnerEventHub, log);
//			//BusinessPartnerValidator.request(businessPartnerEventHub, log, countryCod, partnerRoleList);
//			if (isPartnerFromBrazil(businessPartnerEventHub.getBusinessObject().getAddresses(), countryCod)) {
//				log.setPartnerId(Long.valueOf(businessPartnerEventHub.getBusinessObject().getCode()));
//				//for (DomainPartnerRole domainPartnerRole : partnerRoleList) {
//				//	BusinessPartnerRequest request = BookingMapper.createRequestFromServiceBus(businessPartnerEventHub, countryCod, domainPartnerRole);
//				//	this.sendToService(request, log, domainPartnerRole);
//				}
//			//}
//	//	} catch (ApplicationBusinessException error) {
//		} catch (Exception error) {
//			
//			this.logService.save(this.env.getProperty("error.id"), DomainStatus.UNPROCESSED.getDescription(), error.getLocalizedMessage(), error.getStackTrace(), log);
//		}
//	}
//
//	private void sendToService(BusinessPartnerRequest request, BusinessPartnerLog log, DomainPartnerRole domainPartnerRole) {
//		try {
//			URL url = new URL(this.env.getProperty(domainPartnerRole.getAttribute()));
//			HttpURLConnection con = (HttpURLConnection) url.openConnection();
//			con.setRequestMethod("POST");
//			con.setRequestProperty("Content-Type", "application/json; utf-8");
//			con.setRequestProperty("Accept", "application/json");
//			con.setRequestProperty("locale", "en");
//			con.setRequestProperty("Consumer-Key", this.env.getProperty("consumerkey"));
////			con.setRequestProperty("Authorization", tokenService.getToken());
//			con.setDoOutput(true);
//
//			ObjectMapper mapper = new ObjectMapper();
//			String jsonInputString = mapper.writeValueAsString(request);
//
//			try (OutputStream os = con.getOutputStream()) {
//				byte[] input = jsonInputString.getBytes("utf-8");
//				os.write(input, 0, input.length);
//			}
//
//		//	BusinessPartnerValidator.response(con, log);
//		//} catch (ApplicationBusinessException error) {
//		//	this.logService.save(this.env.getProperty("error.id"), DomainStatus.UNPROCESSED.getDescription(), error.getLocalizedMessage(), error.getStackTrace(), log);
//		} catch (Exception error) {
//			List<LogMoreDetails> errorList = new ArrayList<LogMoreDetails>();
//			errorList.add(new LogMoreDetails(DomainStatus.UNPROCESSED.getDescription(), error.getMessage()));
//			log.setError(errorList);
//			log.setStatus(DomainStatus.UNPROCESSED.getDescription());
//			this.logService.save(this.env.getProperty("error.id"), DomainStatus.UNPROCESSED.getDescription(), error.getLocalizedMessage(), error.getStackTrace(), log);
//		}
//	}
//
//	private Boolean isPartnerFromBrazil(BusinessPartnerAddresses[] partnerAddresses, Integer countryCode) {
//		return Arrays.stream(partnerAddresses).flatMap(s -> Arrays.stream(s.getAddressOverviews()))
//				.anyMatch(ao -> countryCode.equals(Integer.valueOf(ao.getCountryNumber())));
//	}
}