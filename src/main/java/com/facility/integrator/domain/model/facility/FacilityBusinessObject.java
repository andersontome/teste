package com.facility.integrator.domain.model.facility;

import com.facility.integrator.domain.model.Facility;
import com.facility.integrator.domain.model.job.JobExecution;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.io.Serializable;

@Data
@Entity
@Builder
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class FacilityBusinessObject implements Serializable {

    private static final long serialVersionUID = 110828100477053830L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idFacilityBusinessObject;

    @Column
    String code;

    @Column
    Boolean customerFacility;

    @Column
    String version;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "facility_facility_details_id_facility_details")
    FacilityDetails facilityDetails;

    @OneToOne(mappedBy = "facilityBusinessObject", cascade = CascadeType.PERSIST)
    FacilityStatus facilityStatus;

    @OneToOne(mappedBy = "facilityBusinessObject", cascade = CascadeType.PERSIST)
    FacilityCsCode facilityCsCode;

    @OneToOne(mappedBy = "facilityBusinessObject", cascade = CascadeType.PERSIST)
    FacilityCompassCode facilityCompassCode;

    @OneToOne(mappedBy = "facilityBusinessObject", cascade = CascadeType.PERSIST)
    FacilityExtRefCodeType facilityExtRefCodeType;

    @OneToOne(mappedBy = "facilityBusinessObject", cascade = CascadeType.PERSIST)
    Facility facility;

    @ManyToOne
    @JoinColumn(name = "id_job_execution", nullable = false, updatable = false)
    JobExecution jobExecution;

    public void bindAggregates(
            final FacilityDetails facilityDetails,
            final FacilityStatus facilityStatus,
            final FacilityCsCode facilityCsCode,
            final FacilityCompassCode facilityCompassCode,
            final FacilityExtRefCodeType facilityExtRefCodeType,
            final Facility facility
    ) {
        this.facilityDetails = facilityDetails;
        this.facilityStatus = facilityStatus;
        this.facilityCsCode = facilityCsCode;
        this.facilityCompassCode = facilityCompassCode;
        this.facilityExtRefCodeType = facilityExtRefCodeType;
        this.facility = facility;
    }
}
