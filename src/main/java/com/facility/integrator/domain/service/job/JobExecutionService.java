package com.facility.integrator.domain.service.job;

import com.facility.integrator.domain.model.job.JobExecution;
import com.facility.integrator.domain.repository.job.JobExecutionRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;

import static com.facility.integrator.domain.model.job.JobExecution.JobExecutionStatus.PROCESSING;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class JobExecutionService {

    JobExecutionRepository jobExecutionRepository;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public JobExecution startNewJobExecution(final File file) {
        final var jobExecution =
                JobExecution
                        .builder()
                        .fileName(file.getName())
                        .status(PROCESSING)
                        .build();
        return jobExecutionRepository.save(jobExecution);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public JobExecution markJobExecutionAsCompleted(final JobExecution jobExecution) {
        final var completedJobExecution = jobExecution.markAsCompleted();
        return jobExecutionRepository.save(completedJobExecution);
    }

    @Transactional
    public JobExecution save(final JobExecution jobExecution) {
        return jobExecutionRepository.save(jobExecution);
    }
}
