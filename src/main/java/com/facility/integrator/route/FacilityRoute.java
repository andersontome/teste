package com.facility.integrator.route;

import com.facility.integrator.job.FacilityXlsxFileProcessor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import static lombok.AccessLevel.PRIVATE;

@Slf4j
@Component
@FieldDefaults(makeFinal = true, level = PRIVATE)
class FacilityRoute extends RouteBuilder {
    private final String inputFolder;

    private final String outputFolder;

    private final String errorFolder;

    FacilityRoute(@Value("${job.carga.folder.input}") final String inputFolder,
                  @Value("${job.carga.folder.output}") final String outputFolder,
                  @Value("${job.carga.folder.error}") final String errorFolder) {
        this.inputFolder = inputFolder;
        this.outputFolder = outputFolder;
        this.errorFolder = errorFolder;
    }

    @Override
    public void configure() {
        from(inputFolder)
                .log("msg=Starting file processing, fileName=${header.CamelFileName}")
                .doTry()
                    .bean(FacilityXlsxFileProcessor.class)
                    .to(outputFolder)
                    .log("msg=Processing finished")
                .doCatch(Throwable.class)
                    .to(errorFolder)
                    .process((Exchange ex) ->
                        log.error("msg=Fail to process file - Moving file to error folder", ex.getProperty(Exchange.EXCEPTION_CAUGHT, Throwable.class))
                    )
                .end();
    }
}
