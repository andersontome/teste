package com.bpma.integrator.core.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bpma.integrator.core.domain.model.Bpma;

@Repository
public interface BpmaRepository extends JpaRepository<Bpma, Long> {

}
