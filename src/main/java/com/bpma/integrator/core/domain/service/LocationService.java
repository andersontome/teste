package com.bpma.integrator.core.domain.service;

import org.springframework.stereotype.Service;

import com.bpma.integrator.core.domain.model.Location;
import com.bpma.integrator.core.domain.repository.LocationRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LocationService {

	private LocationRepository locationRepository;

	public Location save(Location location) {
	
		tratarListas(location);

		return locationRepository.save(location);
	}

	private void tratarListas(Location location) {
		
		location.getBusinessObject().getLocationNaming()
				.forEach(ln -> ln.setLocationBusinessObject(location.getBusinessObject()));

		location.getBusinessObject().getLocationLogHierarchy()
				.forEach(llh -> llh.setLocationBusinessObject(location.getBusinessObject()));

		location.getBusinessObject().getLocationCsCode()
				.forEach(lcc -> lcc.setLocationBusinessObject(location.getBusinessObject()));
	}
}
