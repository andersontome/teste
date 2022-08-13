package com.facility.integrator.route;

import java.io.File;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.Flow.Processor;

import javax.persistence.criteria.Expression;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.facility.integrator.domain.model.FacilityCarga;
import com.facility.integrator.domain.service.FacilityReadService;

import okhttp3.internal.connection.Exchange;

@Component
public class FacilityRoute {
//public class FacilityRoute extends RouteBuilder{ 
//    final CamelContext camelContext;
//    private FacilityReadService facilityReadService;
//
//    @Autowired
//    public FacilityRoute(CamelContext camelContext, FacilityReadService facilityReadService) {
//        this.camelContext =  camelContext;
//        this.facilityReadService = facilityReadService;
//    }
//
//    @Override
//    public void configure() throws Exception {
//        // move file folde HAM to SAO
//       from(\"src/main/resources/facility110.xlsx\")
//       .routeId("ROUTE-MOVE-FILE-HAM")  
//       .choice()
//       .to("\"src/main/resources/facility110.xlsx\")
//       
//       .process(new Processor() {
//    	@Override
//        public void process(Exchange exchange) throws Exception {
//            String fileProcessedId = (String)exchange.getIn().getHeader(Exchange.FILE_NAME) + (Long)exchange.getIn().getHeader(Exchange.FILE_LAST_MODIFIED);    
//            fileProcessedRepository.insert(fileProcessedId,LocalDateTime.now(),"BAPLIE");
//            }
//        })
//        .endChoice();
//
//
//        // Route for read file and persist in database and send for kafka
//        from("file://{{app.baplies.input.folder}}?preMove={{app.baplies.folder}}&move={{app.baplies.folder.success}}${file:name}_${date:now:yyyyMMddHHmmss}&scheduler=spring&scheduler.cron={{app.camel.cron}}")
//        .routeId("ROUTE-BABLIE")
//        .doTry()
//            .transform(new Expression(){
//                @CaptureSpan(value = "TransformBaplie")
//                @Override
//                public <T> T evaluate(Exchange exchange, Class<T> type) {
//                    lastDateProcess = LocalDateTime.now();
//                    File file =  (File) exchange.getIn().getBody();
//                    List<Baplie> baplies = null;
//                    try {
//                        baplies = baplieService.readExcel(file);                    
//                    } catch (Exception e) {
//                        log.error("Error to process xls, ERROR =>", e);
//                    }
//                    return (T) baplies;
//                }
//            })
//        .doCatch(Exception.class).to("direct:sendMailError");
//    }
}
