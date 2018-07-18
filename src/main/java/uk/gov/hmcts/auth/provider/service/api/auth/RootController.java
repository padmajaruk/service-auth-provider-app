package uk.gov.hmcts.auth.provider.service.api.auth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.gov.hmcts.auth.provider.service.api.config.AppProperties;

import static org.springframework.http.ResponseEntity.ok;

/**
 * Default endpoints per application.
 */
@RestController
public class RootController {

    private static final Logger log = LoggerFactory.getLogger(AuthService.class);

    @Autowired
    private AppProperties appProperties;


    /**
     * Root GET endpoint.
     *
     * <p>Azure application service has a hidden feature of making requests to root endpoint when
     * "Always On" is turned on.
     * This is the endpoint to deal with that and therefore silence the unnecessary 404s as a response code.
     *
     * @return Welcome message from the service.
     */
    @GetMapping
    public ResponseEntity<String> welcome() {
        log.info("Local cache test = {}, {}, {}, {}",
            appProperties.getMicroserviceKeys().get("MICROSERVICEKEYS_CHECK_LOCAL_CACHE"),
            appProperties.getMicroserviceKeys().get("microservicekeys_check_local_cache"),
            appProperties.getMicroserviceKeys().get("CHECK_LOCAL_CACHE"),
            appProperties.getMicroserviceKeys().get("check_local_cache")
        );
        log.info("Bulk scan processor = {}, {}, {}, {}",
            appProperties.getMicroserviceKeys().get("MICROSERVICEKEYS_BULK_SCAN_PROCESSOR"),
            appProperties.getMicroserviceKeys().get("microservicekeys_bulk_scan_processor"),
            appProperties.getMicroserviceKeys().get("BULK_SCAN_PROCESSOR"),
            appProperties.getMicroserviceKeys().get("bulk_scan_processor")
        );
        return ok("Welcome to Service Auth Provider");
    }
}
