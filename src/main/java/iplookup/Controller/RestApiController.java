package iplookup.Controller;

import iplookup.Model.IpAddress;
import iplookup.Service.Ip2LocationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST Controller
 */
@RestController
@RequestMapping("/api")
public class RestApiController {
    private final Ip2LocationService ip2LocationService;

    public RestApiController(Ip2LocationService ip2LocationService) {
        this.ip2LocationService = ip2LocationService;
    }

    /**
     * Gets ip data for a specified ip address
     * @param ipAddress ip address
     * @return ip data
     */
    @GetMapping("/iplookup")
    public ResponseEntity<?> lookupIP(@RequestBody IpAddress ipAddress) {
        try {
            return ResponseEntity
                    .status(HttpStatus.ACCEPTED)
                    .body(ip2LocationService.ipLookup(ipAddress.getIp()));
        } catch(Exception e) {
            return ResponseEntity
                    .badRequest()
                    .body(e.getMessage());
        }
    }
}
