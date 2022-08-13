package com.facility.integrator.domain.model;

import java.util.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FacilityCarga {

	private Integer facilityCode;
	private Integer facilityCustomerfacility;
	private Integer facilityVersion;
	private String chronologyEffectivefrom;
	private String chronologyEffectiveto;
	private Integer chronologyVersion;
	private String chronNamingCode;
	private String chronNamingName;
	private Integer chronLoghierarchyParent;
	private Integer chronPartnerPartnernumber;
	private String chronPartnerPartnercode;
	private String detailsAccAccessmode;
	private Integer detailsAccVersion;
	private String detailsFunctFunctiontype;
	private Integer detailsFunctVersion;
	private String deatilsHourHourtype;
	private String deatilsHourDaytype;
	private String deatilsHourFromtime;
	private String deatilsHourTotime;
	private String facstatusStatus;
	private String facstatusEffectivefrom;
	private String facstatusEffectiveto;
	private Integer facstatusVersion;
	
}
