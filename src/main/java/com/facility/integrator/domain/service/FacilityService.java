package com.facility.integrator.domain.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.facility.integrator.domain.model.Facility;
import com.facility.integrator.domain.repository.FacilityRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FacilityService {

	private FacilityRepository facilityRepository;

	public Facility save(Facility facility) {

		tratarListas(facility);

		return facilityRepository.save(facility);
	}

	public Optional<Facility> getFacilityPorCode(String code) {
		return facilityRepository.findByFacilityBusinessObjectCode(code).stream().sorted((f1, f2) -> {
			try {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss");
				Date dateF1 = sdf.parse(f1.getProcessData().getVersionNumber());
				Date dateF2 = sdf.parse(f2.getProcessData().getVersionNumber());
				return -dateF1.compareTo(dateF2);
			} catch (ParseException e) {
				e.printStackTrace();
			    return 0;
			}
		}).findFirst();
	}

	private void tratarListas(Facility facility) {

		facility.getFacilityBusinessObject().getFacilityChronology()
				.forEach(c -> c.setFacilityBusinessObject(facility.getFacilityBusinessObject()));

		facility.getFacilityBusinessObject().getFacilityFacilityDetails().getFacilityAccess().forEach(
				fa -> fa.setFacilityDetails(facility.getFacilityBusinessObject().getFacilityFacilityDetails()));

		facility.getFacilityBusinessObject().getFacilityFacilityDetails().getFacilityFunction().forEach(
				ff -> ff.setFacilityDetails(facility.getFacilityBusinessObject().getFacilityFacilityDetails()));

		facility.getFacilityBusinessObject().getFacilityFacilityDetails().getFacilityHour().forEach(
				fh -> fh.setFacilityDetails(facility.getFacilityBusinessObject().getFacilityFacilityDetails()));

		facility.getFacilityBusinessObject().getFacilityFacilityStatus()
				.forEach(s -> s.setFacilityBusinessObject(facility.getFacilityBusinessObject()));

		facility.getFacilityBusinessObject().getFacilityFacilityCsCode()
				.forEach(fc -> fc.setFacilityBusinessObject(facility.getFacilityBusinessObject()));

		facility.getFacilityBusinessObject().getFacilityFacilityCompassCode()
				.forEach(cc -> cc.setFacilityBusinessObject(facility.getFacilityBusinessObject()));

	}
}
