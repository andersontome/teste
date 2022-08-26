package com.bpma.integrator.core.controller;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bpma.integrator.core.domain.model.Facility;
import com.bpma.integrator.core.domain.service.FacilityService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/facilities")
@AllArgsConstructor
public class FacilityController {

	private FacilityService facilityService;
	
	@GetMapping("/{code}")
	public ResponseEntity<Facility> buscarPorCode(@PathVariable String code) {
		Optional<Facility> facilityOptional = facilityService.getFacilityPorCode(code);
		
		if(facilityOptional.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
				
		return ResponseEntity.ok(facilityOptional.get());
	}
}
