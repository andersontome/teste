package com.bpma.integrator.core.domain.service;

import org.springframework.stereotype.Service;

import com.bpma.integrator.core.domain.model.City;
import com.bpma.integrator.core.domain.repository.CityRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CityService {

	private CityRepository cityRepository;

	public City save(City city) {
		
		tratarListas(city);

		return cityRepository.save(city);
	}

	private void tratarListas(City city) {
		
		city.getCityBusinessObject().getCityNaming()
				.forEach(cn -> cn.setCityBusinessObject(city.getCityBusinessObject()));

		city.getCityBusinessObject().getCityLocation()
				.forEach(cl -> cl.setCityBusinessObject(city.getCityBusinessObject()));

		city.getCityBusinessObject().getCityPostalCodeRange()
				.forEach(pcr -> pcr.setCityBusinessObject(city.getCityBusinessObject()));

		city.getCityBusinessObject().getCityCompassCode()
				.forEach(cc -> cc.setCityBusinessObject(city.getCityBusinessObject()));

		city.getCityBusinessObject().getCityUsCode()
				.forEach(uc -> uc.setCityBusinessObject(city.getCityBusinessObject()));
	}
}
