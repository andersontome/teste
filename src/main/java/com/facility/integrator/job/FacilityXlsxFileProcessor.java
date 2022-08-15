package com.facility.integrator.job;

import com.facility.integrator.domain.model.job.JobExecution;
import com.facility.integrator.domain.service.facility.FacilityService;
import com.facility.integrator.domain.service.file.reader.FacilityReadService;
import com.facility.integrator.domain.service.job.JobExecutionService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.File;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class FacilityXlsxFileProcessor {

    JobExecutionService jobExecutionService;

    FacilityReadService facilityReadService;

    FacilityService facilityService;

    public void processFile(final File file) {
        final JobExecution jobExecution = startNewJobExecution(file);

        try {
            final var xlsxFileContent = facilityReadService.getXlsxFileContentSkippingHeader(file);
            facilityService.saveAllFacilitiesAndAggregates(jobExecution, xlsxFileContent);

            jobExecutionService.markJobExecutionAsCompleted(jobExecution);
            log.info("msg=jobExecution marked as COMPLETED, jobExecutionId={}", jobExecution.getId());

        } catch (final Exception ex) {
            final JobExecution failedJobExecution = jobExecution.markAsFail();
            jobExecutionService.save(failedJobExecution);
            throw ex;
        }
    }

    private JobExecution startNewJobExecution(final File file) {
        log.info("msg=Creating new jobExecution entry");
        final JobExecution jobExecution = jobExecutionService.startNewJobExecution(file);
        log.info("msg=jobExecution created, jobExecutionId={}", jobExecution.getId());
        return jobExecution;
    }
}
