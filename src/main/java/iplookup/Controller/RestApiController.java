package iplookup.Controller;

import iplookup.Model.IpAddress;
import iplookup.Model.IpAddressData;
import iplookup.Model.WhoisData;
import iplookup.Model.Whois;
import iplookup.Service.IpLookupService;
import iplookup.Service.WhoisLookupService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestApiController {
    private final IpLookupService ipLookupService;
    private final WhoisLookupService whoisLookupService;

    public RestApiController(IpLookupService ipLookupService, WhoisLookupService whoisLookupService) {
        this.ipLookupService = ipLookupService;
        this.whoisLookupService = whoisLookupService;
    }

    @GetMapping("/api/iplookup")
    public ResponseEntity<?> lookupIP(@RequestBody IpAddress ipAddress) {
        try {
            IpAddressData data = ipLookupService.lookUp(ipAddress.getIp());
            return ResponseEntity
                    .status(HttpStatus.ACCEPTED)
                    .body(data);
        } catch(Exception e) {
            return ResponseEntity
                    .badRequest()
                    .body(e.getMessage());
        }
    }

    @GetMapping("/api/whois")
    public ResponseEntity<?> whois(@RequestBody Whois whois) {
        try {
            WhoisData data = whoisLookupService.lookUp(whois.getDomain());
            return ResponseEntity
                    .status(HttpStatus.ACCEPTED)
                    .body(data);
        } catch(Exception e) {
            return ResponseEntity
                    .badRequest()
                    .body(e.getMessage());
        }
    }
}
