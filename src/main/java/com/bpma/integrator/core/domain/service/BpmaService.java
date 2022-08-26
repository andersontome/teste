package com.bpma.integrator.core.domain.service;

import org.springframework.stereotype.Service;

import com.bpma.integrator.core.domain.model.Bpma;
import com.bpma.integrator.core.domain.model.bpma.BusinessObject;
import com.bpma.integrator.core.domain.model.bpma.FormattedAddress;
import com.bpma.integrator.core.domain.repository.BpmaRepository;
import com.bpma.integrator.core.domain.repository.FormattedAddressRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BpmaService {

	private BpmaRepository bpmaRepository;
	
	private FormattedAddressRepository formattedAddressRepository;
	
	public Bpma save(Bpma bpma) {
		
		tratarListas(bpma);
		
		bpma =  bpmaRepository.save(bpma);
		
		bpma.getBusinessObject().getAddresses().forEach(a -> {
			
			a.getFormattedAddress().forEach(fa -> {
				FormattedAddress formattedAddress = new FormattedAddress();
				formattedAddress.setFormattedAddress(fa);
				formattedAddress.setAddresses(a);
				formattedAddressRepository.save(formattedAddress);
			});
			
		});
		
		return bpma;
		
	}

	private void tratarListas(Bpma bpma) {
		
		BusinessObject businessObject = bpma.getBusinessObject();
		
		bpma.getBusinessObject().getPartnerNames().forEach(pn -> pn.setBusinessObject(businessObject));
		
		bpma.getBusinessObject().getBoycottStatuses().forEach(bt -> bt.setBusinessObject(businessObject));
		
		bpma.getBusinessObject().getPartnerRoles().forEach(pr -> {
			
			pr.getPartnerFunctions().forEach(pf -> pf.setPartnerRoles(pr));
			pr.getCommunicationPreferences().forEach(cp -> cp.setPartnerRoles(pr));
			pr.getBillToParties().forEach(btp -> btp.setPartnerRoles(pr));
			pr.getOperatorCodes().forEach(oc -> oc.setPartnerRoles(pr));
			pr.setBusinessObject(businessObject);
		});
		
		bpma.getBusinessObject().getTaxNumbers().forEach(tn -> tn.setBusinessObject(businessObject));
		bpma.getBusinessObject().getAddresses().forEach(a -> {
			
			a.getAddressOverviews().forEach(ao -> ao.setAddresses(a));
			
			a.getContacts().forEach(c -> {
				
				c.getCommunicationDetails().forEach(cd -> cd.setContacts(c));
				
				c.setAddresses(a);
			});
			a.getReferencingFiAccounts().forEach(rfa -> rfa.setAddresses(a));
			
			a.setBusinessObject(businessObject);
		});
		
		bpma.getBusinessObject().getFiAccounts().forEach(fa -> fa.setBusinessObject(businessObject));
		
		bpma.getBusinessObject().getEcommerceChannels().forEach(ec -> {
			
			ec.getEcommerceProducts().forEach(ep -> ep.setEcommerceChannels(ec));
			
			ec.setBusinessObject(businessObject);
		});
		
	}
}
