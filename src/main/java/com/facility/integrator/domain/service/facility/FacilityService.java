package com.facility.integrator.domain.service.facility;

import com.facility.integrator.common.file.xlsx.FacilityFileContent;
import com.facility.integrator.domain.model.Facility;
import com.facility.integrator.domain.model.ProcessData;
import com.facility.integrator.domain.model.facility.FacilityAccess;
import com.facility.integrator.domain.model.facility.FacilityBusinessObject;
import com.facility.integrator.domain.model.facility.FacilityCompassCode;
import com.facility.integrator.domain.model.facility.FacilityCsCode;
import com.facility.integrator.domain.model.facility.FacilityDetails;
import com.facility.integrator.domain.model.facility.FacilityExtRefCodeType;
import com.facility.integrator.domain.model.facility.FacilityFunction;
import com.facility.integrator.domain.model.facility.FacilityHour;
import com.facility.integrator.domain.model.facility.FacilityStatus;
import com.facility.integrator.domain.model.job.JobExecution;
import com.facility.integrator.domain.repository.businessobject.FacilityBusinessObjectRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class FacilityService {

    FacilityBusinessObjectRepository facilityBusinessObjectRepository;

    TransactionTemplate transactionTemplate;

    public void saveAllFacilitiesAndAggregates(final JobExecution jobExecution, final List<FacilityFileContent> fileContentList) {
        final var startedAt = System.currentTimeMillis();
        log.info("msg=Starting to convert file content to domain objects, totalEntries={}", fileContentList.size());

        final var counter = new AtomicInteger();
        final var chunkSize = 25;
        fileContentList
                .stream()
                .map(it -> this.buildDomainObjectsFromFileContent(jobExecution, it))
                .collect(Collectors.groupingBy(n -> counter.getAndIncrement() / chunkSize))
                .values()
                .stream()
                .parallel()
                .forEach(chunk -> {
                    transactionTemplate.execute(status -> {
                        chunk.forEach(facilityBusinessObjectRepository::save);
                        return null;
                    });
                });

        log.info("msg=Domain objects persistence done, timeElapsed={}ms", System.currentTimeMillis() - startedAt);
    }

    private FacilityBusinessObject buildDomainObjectsFromFileContent(final JobExecution jobExecution, final FacilityFileContent content) {
        // FacilityDetails & FacilityAccess & FacilityFunction & FacilityHour
        final var facilityDetails = new FacilityDetails();
        final var facilityAccess = FacilityAccess
                .builder()
                .accessMode(content.getDetailsAccAccessMode())
                .version(content.getDetailsAccVersion())
                .facilityDetails(facilityDetails)
                .build();
        final var facilityFunction = FacilityFunction
                .builder()
                .facilityFunctionType(content.getDetailsFunctFunctionType())
                .facilityDetails(facilityDetails)
                .build();
        final var facilityHour = FacilityHour
                .builder()
                .facilityDetails(facilityDetails)
                .build();
        facilityDetails.bindAggregates(facilityAccess, facilityFunction, facilityHour);


        // FacilityBusinessObject & FacilityStatus & FacilityCsCode & FacilityCompassCode & FacilityExtRefCodeType
        final var facilityBusinessObject = FacilityBusinessObject
                .builder()
                .code(content.getFacilityCode())
                .customerFacility(content.getFacilityCustomerFacility() == 1)
                .version(content.getFacilityVersion())
                .jobExecution(jobExecution)
                .build();
        final var facilityStatus = FacilityStatus
                .builder()
                .effectiveFrom(content.getFacStatusEffectiveFrom().toString())
                .effectiveTo(content.getFacStatusEffectiveTo().toString())
                .status(content.getFacstatusStatus())
                .version(content.getFacStatusVersion())
                .facilityBusinessObject(facilityBusinessObject)
                .build();
        final var facilityCsCode = FacilityCsCode.builder().facilityBusinessObject(facilityBusinessObject).build();
        final var facilityCompassCode = FacilityCompassCode.builder().facilityBusinessObject(facilityBusinessObject).build();
        final var facilityExtRefCodeType = FacilityExtRefCodeType.builder().facilityBusinessObject(facilityBusinessObject).build();


        // ProcessData & Facility
        final var processData = ProcessData
                .builder()
                .changeType("UPDATE")
                .versionNumber("2022-07-28T01:00:00.000")
                .build();
        final var facility = Facility.builder().facilityBusinessObject(facilityBusinessObject).processData(processData).build();
        facilityBusinessObject.bindAggregates(facilityDetails, facilityStatus, facilityCsCode, facilityCompassCode, facilityExtRefCodeType, facility);
        return facilityBusinessObject;
    }
}
