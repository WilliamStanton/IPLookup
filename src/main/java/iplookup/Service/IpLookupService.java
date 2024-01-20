package iplookup.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import iplookup.Repository.EnvRepository;
import iplookup.Model.IpAddressData;
import org.springframework.stereotype.Service;

@Service
public class IpLookupService {
    // Initialize Repository
    private final Ip2LocationService ip2LocationService;
    public IpLookupService(Ip2LocationService ip2LocationService) {
        this.ip2LocationService = ip2LocationService;
    }

    /**
     * The lookUp method returns an object (model) containing information
     * found regarding the IP Address entered
     * @param ip the IP Address to look up
     * @return the object (model) holding the IP Information
     */
    public IpAddressData lookUp(String ip) {
        try {
            // Obtain & Map data to object
            JsonObject data = ip2LocationService.getIp(ip);
            IpAddressData results = new ObjectMapper().readValue(data.toString(), IpAddressData.class);

            // Return successful object (model)
            return results;
        } catch(Exception e) {
            // Print error
            System.out.println(e.getMessage());
        }

        // Return empty object (model)
        return new IpAddressData();
    }
}
