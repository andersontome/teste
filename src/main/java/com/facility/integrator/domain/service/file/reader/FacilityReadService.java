package com.facility.integrator.domain.service.file.reader;

import com.facility.integrator.common.file.xlsx.FacilityFileContent;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class FacilityReadService {

    public List<FacilityFileContent> getXlsxFileContentSkippingHeader(final File file) {
        log.info("msg=Start to read file '{}'", file.getName());
        final var startedAt = System.currentTimeMillis();

        try (final InputStream is = new FileInputStream(file)) {
            final var workbook = new XSSFWorkbook(is);
            final var sheet = workbook.getSheetAt(0);

            var xlsxContent = StreamSupport.stream(sheet.spliterator(), false)
                    .skip(1)
                    .map(it -> FacilityFileContent.builder()
                            .facilityCode(String.valueOf(it.getCell(0).getNumericCellValue()))
                            .facilityCustomerFacility((int) it.getCell(1).getNumericCellValue())
                            .facilityVersion(String.valueOf(it.getCell(2).getNumericCellValue()))
                            .chronologyEffectiveFrom(LocalDate.parse(it.getCell(3).getStringCellValue()))
                            .chronologyEffectiveTo(LocalDate.parse(it.getCell(4).getStringCellValue()))
                            .chronologyVersion((int) it.getCell(5).getNumericCellValue())
                            .chronNamingCode(it.getCell(6).getStringCellValue())
                            .chronNamingName(it.getCell(7).getStringCellValue())
                            .chronLogHierarchyParent((long) it.getCell(8).getNumericCellValue())
                            .chronPartnerPartnerNumber((long) it.getCell(9).getNumericCellValue())
                            .chronPartnerPartnerCode(it.getCell(10).getStringCellValue())
                            .detailsAccAccessMode(it.getCell(11).getStringCellValue())
                            .detailsAccVersion(String.valueOf(it.getCell(12).getNumericCellValue()))
                            .detailsFunctFunctionType(it.getCell(13).getStringCellValue())
                            .detailsFunctVersion((int) it.getCell(14).getNumericCellValue())
                            .deatilsHourHourType(it.getCell(15).getStringCellValue())
                            .deatilsHourDayType(it.getCell(16).getStringCellValue())
                            .deailtsHourFromTime(it.getCell(17).getStringCellValue())
                            .deatilsHourToTime(it.getCell(18).getStringCellValue())
                            .facstatusStatus(it.getCell(19).getStringCellValue())
                            .facStatusEffectiveFrom(LocalDate.parse(it.getCell(20).getStringCellValue()))
                            .facStatusEffectiveTo(LocalDate.parse(it.getCell(21).getStringCellValue()))
                            .facStatusVersion(String.valueOf(it.getCell(22).getNumericCellValue()))
                            .build()).collect(Collectors.toUnmodifiableList());

            log.info("msg=File read successfully, timeElapsed={}ms", System.currentTimeMillis() - startedAt);
            return xlsxContent;
        } catch (Throwable ex) {
            throw new FailToReadXlsxFileContent(file, ex);
        }
    }
}