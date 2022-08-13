package com.facility.integrator.job;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.apache.commons.collections4.IteratorUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.facility.integrator.domain.model.Facility;
import com.facility.integrator.domain.model.FacilityCarga;
import com.facility.integrator.domain.model.ProcessData;
import com.facility.integrator.domain.model.facility.FacilityAccess;
import com.facility.integrator.domain.model.facility.FacilityBusinessObject;
import com.facility.integrator.domain.model.facility.FacilityChronology;
import com.facility.integrator.domain.model.facility.FacilityCompassCode;
import com.facility.integrator.domain.model.facility.FacilityCsCode;
import com.facility.integrator.domain.model.facility.FacilityDetails;
import com.facility.integrator.domain.model.facility.FacilityExtRefCodeType;
import com.facility.integrator.domain.model.facility.FacilityFunction;
import com.facility.integrator.domain.model.facility.FacilityHour;
import com.facility.integrator.domain.model.facility.FacilityLogHierarchy;
import com.facility.integrator.domain.model.facility.FacilityNaming;
import com.facility.integrator.domain.model.facility.FacilityPartner;
import com.facility.integrator.domain.model.facility.FacilityStatus;
import com.facility.integrator.domain.service.FacilityService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;
import lombok.Cleanup;

@Component
@AllArgsConstructor
public class FacilityJob {

	@Autowired
	public FacilityJob() {
	}

	int i = 0;
	int facilityCodeAux = 0;
	long facilityIdCodeAux = 0;
	boolean isParaAtualizar = true;

	@Autowired
	private FacilityService facilityService;

	@Scheduled(fixedDelayString = "${time.schedule.carga}")
	public void execute() throws IOException {

		List<FacilityCarga> facilityCargas = new ArrayList<>();

		IOUtils.setByteArrayMaxOverride(244373408);

		// Recuperar Planilha Carga
		@Cleanup
		FileInputStream file = new FileInputStream("src/main/resources/facilityProd.xlsx");
		Workbook workbook = new XSSFWorkbook(file);

		// Setando a aba da leitura
		Sheet sheet = workbook.getSheetAt(0);

		// Setando as linhas da planilha
		List<Row> rows = (List<Row>) toList(sheet.iterator());

		rows.remove(0);

		Facility facility = new Facility();
		ProcessData processData = new ProcessData();
		FacilityBusinessObject facilityBusinessObject = new FacilityBusinessObject();
		List<FacilityChronology> facilityChronology = new ArrayList<FacilityChronology>();
		List<FacilityCsCode> facilityCsCode = new ArrayList<FacilityCsCode>();
		List<FacilityCompassCode> facilityCompassCode = new ArrayList<FacilityCompassCode>();
		List<FacilityExtRefCodeType> facilityExtRefCodeType = new ArrayList<FacilityExtRefCodeType>();
		FacilityDetails facilityDetails = new FacilityDetails();
		List<FacilityAccess> facilityAccess = new ArrayList<FacilityAccess>();
		List<FacilityFunction> facilityFunction = new ArrayList<FacilityFunction>();
		List<FacilityHour> facilityHour = new ArrayList<FacilityHour>();
		List<FacilityStatus> facilityStatus = new ArrayList<FacilityStatus>();

		facility.setProcessData(processData);
		facility.setFacilityBusinessObject(facilityBusinessObject);
		facilityBusinessObject.setFacilityChronology(facilityChronology);
		facilityBusinessObject.setFacilityFacilityDetails(facilityDetails);
		facilityBusinessObject.setFacilityFacilityCsCode(facilityCsCode);
		facilityBusinessObject.setFacilityFacilityCompassCode(facilityCompassCode);
		facilityBusinessObject.setFacilityExtRefCodeType(facilityExtRefCodeType);
		facilityDetails.setFacilityAccess(facilityAccess);
		facilityDetails.setFacilityFunction(facilityFunction);
		facilityDetails.setFacilityHour(facilityHour);
		facilityBusinessObject.setFacilityFacilityStatus(facilityStatus);

		rows.forEach(row -> {

			// Setando as celulas da planilha
			List<Cell> cells = (List<Cell>) toList(row.cellIterator());

			FacilityCarga facilityCarga = FacilityCarga.builder()

					.facilityCode((int) cells.get(0).getNumericCellValue())
					.facilityCustomerfacility((int) cells.get(1).getNumericCellValue())
					.facilityVersion((int) cells.get(2).getNumericCellValue())
					.chronologyEffectivefrom(cells.get(3).getStringCellValue())
					.chronologyEffectiveto(cells.get(4).getStringCellValue())
					.chronologyVersion((int) cells.get(5).getNumericCellValue())
					.chronNamingCode(cells.get(6).getStringCellValue())
					.chronNamingName(cells.get(7).getStringCellValue())
					.chronLoghierarchyParent((int) cells.get(8).getNumericCellValue())
					.chronPartnerPartnernumber((int) cells.get(9).getNumericCellValue())
					.chronPartnerPartnercode(cells.get(10).getStringCellValue())
					.detailsAccAccessmode(cells.get(11).getStringCellValue())
					.detailsAccVersion((int) cells.get(12).getNumericCellValue())
					.detailsFunctFunctiontype(cells.get(13).getStringCellValue())
					.detailsFunctVersion((int) cells.get(14).getNumericCellValue())
					.deatilsHourHourtype(cells.get(15).getStringCellValue())
					.deatilsHourDaytype(cells.get(16).getStringCellValue())
					.deatilsHourFromtime(cells.get(17).getStringCellValue())
					.deatilsHourTotime(cells.get(18).getStringCellValue())
					.facstatusStatus(cells.get(19).getStringCellValue())
					.facstatusEffectivefrom(cells.get(20).getStringCellValue())
					.facstatusEffectiveto(cells.get(21).getStringCellValue())
					.facstatusVersion((int) cells.get(22).getNumericCellValue())

					.build();

			if (facilityCarga.getFacilityCode() != facilityCodeAux) {

				if (facilityCodeAux != 0) {
					
					var objectMapper = new ObjectMapper();
					Facility facilitySave = null;
				    try {
						var json = objectMapper.writeValueAsString(facility);
						
						facilitySave = objectMapper.readValue(json, Facility.class);
						
					} catch (JsonProcessingException e) {
						e.printStackTrace();
					}
					
					// Service para realizar a carga no postgres
					facilityService.save(facilitySave);
					System.out.println(facilityCodeAux);
				}

//				isParaAtualizar = false;

				facilityCodeAux = facilityCarga.getFacilityCode();

				// ProcessData
				facility.getProcessData().setChangeType("UPDATE");
				facility.getProcessData().setVersionNumber("2022-07-28T01:00:00.000");

				// BusinessObject
				facility.getFacilityBusinessObject().setCode(String.valueOf(facilityCarga.getFacilityCode()));
				facility.getFacilityBusinessObject().setVersion(String.valueOf(facilityCarga.getFacilityVersion()));

				if (facilityCarga.getFacilityCustomerfacility() == 0) {
					facility.getFacilityBusinessObject().setCustomerFacility(false);
				} else {
					facility.getFacilityBusinessObject().setCustomerFacility(true);
				}

				// Chronology (BusinessObject)
				FacilityChronology objectFacilityChronology = new FacilityChronology();
				FacilityNaming facilityNaming = new FacilityNaming();
				FacilityLogHierarchy facilityLogHierarchy = new FacilityLogHierarchy();
				FacilityPartner facilityPartner = new FacilityPartner();

				objectFacilityChronology.setEffectiveFrom(facilityCarga.getChronologyEffectivefrom());
				objectFacilityChronology.setEffectiveTo(facilityCarga.getChronologyEffectiveto());
				objectFacilityChronology.setVersion(String.valueOf(facilityCarga.getChronologyVersion()));
				facilityNaming.setCode(facilityCarga.getChronNamingCode());
				facilityNaming.setName(facilityCarga.getChronNamingName());
				facilityLogHierarchy.setParent(String.valueOf(facilityCarga.getChronLoghierarchyParent()));
				facilityPartner.setPartnerNumber(String.valueOf(facilityCarga.getChronPartnerPartnernumber()));
				facilityPartner.setPartnerCode(facilityCarga.getChronPartnerPartnercode());

				objectFacilityChronology.setFacilityNaming(facilityNaming);
				objectFacilityChronology.setFacilityLogHierarchy(facilityLogHierarchy);
				objectFacilityChronology.setFacilityPartner(facilityPartner);
				facilityChronology.add(objectFacilityChronology);

				// FacilityDetails (BusinessObject)
				FacilityAccess objectFacilityAccess = new FacilityAccess();
				objectFacilityAccess.setAccessMode(facilityCarga.getDetailsAccAccessmode());
				objectFacilityAccess.setVersion(String.valueOf(facilityCarga.getDetailsAccVersion()));
				facilityAccess.add(objectFacilityAccess);

				FacilityFunction objectFacilityFunction = new FacilityFunction();
				objectFacilityFunction.setFacilityFunctionType(facilityCarga.getDetailsFunctFunctiontype());
				facilityFunction.add(objectFacilityFunction);

				// FacilityStatus (BusinessObject)
				FacilityStatus objectFacilityStatus = new FacilityStatus();
				objectFacilityStatus.setStatus(facilityCarga.getFacstatusStatus());
				objectFacilityStatus.setEffectiveFrom(facilityCarga.getFacstatusEffectivefrom());
				objectFacilityStatus.setEffectiveTo(facilityCarga.getFacstatusEffectiveto());
				objectFacilityStatus.setVersion(String.valueOf(facilityCarga.getFacstatusVersion()));
				facilityStatus.add(objectFacilityStatus);

			} else {

				if (facilityCarga.getFacilityCode() == facilityCodeAux) {

					// Chronology (BusinessObject)
					FacilityChronology objectFacilityChronology = new FacilityChronology();
					FacilityNaming facilityNaming = new FacilityNaming();
					FacilityLogHierarchy facilityLogHierarchy = new FacilityLogHierarchy();
					FacilityPartner facilityPartner = new FacilityPartner();

					objectFacilityChronology.setEffectiveFrom(facilityCarga.getChronologyEffectivefrom());
					objectFacilityChronology.setEffectiveTo(facilityCarga.getChronologyEffectiveto());
					objectFacilityChronology.setVersion(String.valueOf(facilityCarga.getChronologyVersion()));
					facilityNaming.setCode(facilityCarga.getChronNamingCode());
					facilityNaming.setName(facilityCarga.getChronNamingName());
					facilityLogHierarchy.setParent(String.valueOf(facilityCarga.getChronLoghierarchyParent()));
					facilityPartner.setPartnerNumber(String.valueOf(facilityCarga.getChronPartnerPartnernumber()));
					facilityPartner.setPartnerCode(facilityCarga.getChronPartnerPartnercode());

					objectFacilityChronology.setFacilityNaming(facilityNaming);
					objectFacilityChronology.setFacilityLogHierarchy(facilityLogHierarchy);
					objectFacilityChronology.setFacilityPartner(facilityPartner);
					facilityChronology.add(objectFacilityChronology);

					// FacilityDetails (BusinessObject)
					FacilityAccess objectFacilityAccess = new FacilityAccess();
					objectFacilityAccess.setAccessMode(facilityCarga.getDetailsAccAccessmode());
					objectFacilityAccess.setVersion(String.valueOf(facilityCarga.getDetailsAccVersion()));
					facilityAccess.add(objectFacilityAccess);

					FacilityFunction objectFacilityFunction = new FacilityFunction();
					objectFacilityFunction.setFacilityFunctionType(facilityCarga.getDetailsFunctFunctiontype());
					facilityFunction.add(objectFacilityFunction);

					// FacilityStatus (BusinessObject)
					FacilityStatus objectFacilityStatus = new FacilityStatus();
					objectFacilityStatus.setStatus(facilityCarga.getFacstatusStatus());
					objectFacilityStatus.setEffectiveFrom(facilityCarga.getFacstatusEffectivefrom());
					objectFacilityStatus.setEffectiveTo(facilityCarga.getFacstatusEffectiveto());
					objectFacilityStatus.setVersion(String.valueOf(facilityCarga.getFacstatusVersion()));
					facilityStatus.add(objectFacilityStatus);

				}
			}
		});

	}

	public List<?> toList(Iterator<?> iterator) {
		return IteratorUtils.toList(iterator);
		
	}
}
