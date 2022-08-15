package com.facility.integrator.domain.repository.job;

import com.facility.integrator.domain.model.job.JobExecution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobExecutionRepository extends JpaRepository<JobExecution, Integer> {
}
