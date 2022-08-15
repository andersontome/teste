package com.facility.integrator.common.file.xlsx;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@Builder
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class FacilityFileContent {

    String facilityCode;

    Integer facilityCustomerFacility;

    String facilityVersion;

    LocalDate chronologyEffectiveFrom;

    LocalDate chronologyEffectiveTo;

    Integer chronologyVersion;

    String chronNamingCode;

    String chronNamingName;

    Long chronLogHierarchyParent;

    Long chronPartnerPartnerNumber;

    String chronPartnerPartnerCode;

    String detailsAccAccessMode;

    String detailsAccVersion;

    String detailsFunctFunctionType;

    Integer detailsFunctVersion;

    String deatilsHourHourType;

    String deatilsHourDayType;

    String deailtsHourFromTime;

    String deatilsHourToTime;

    String facstatusStatus;

    LocalDate facStatusEffectiveFrom;

    LocalDate facStatusEffectiveTo;

    String facStatusVersion;
}
