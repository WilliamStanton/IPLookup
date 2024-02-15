package iplookup.Proxy;

import iplookup.Model.IpData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Communicates with the Ip2Location API
 */
@FeignClient(name="IP2Location", url="https://api.ip2location.io/?key=&ip=")
public interface Ip2LocationProxy {
    /**
     * Gets the IP Data
     * @param ip the IP Address
     * @param apiKey the API Key
     * @return IP Data
     */
    @GetMapping("")
    IpData ipLookup(@RequestParam String ip, @RequestParam("key") String apiKey);
}
