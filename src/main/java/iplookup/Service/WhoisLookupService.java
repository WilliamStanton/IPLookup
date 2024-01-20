package iplookup.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import iplookup.Model.WhoisData;
import iplookup.Repository.EnvRepository;
import org.springframework.stereotype.Service;

@Service
public class WhoisLookupService {
    // Initialize Repository
    private final Ip2LocationService ip2LocationService;

    public WhoisLookupService(Ip2LocationService ip2LocationService) {
        this.ip2LocationService = ip2LocationService;
    }

    /**
     * The lookUp method returns an object (model) containing information
     * found regarding the domain entered
     * @param domain the domain to look up
     * @return the object (model) holding the Whois Information
     */
    public WhoisData lookUp(String domain) {
        try {
            // Obtain & Map data to object
            JsonObject data = ip2LocationService.getWhois(domain);
            WhoisData results = new ObjectMapper().readValue(data.toString(), WhoisData.class);

            // Return successful object (model)
            return results;
        } catch(Exception e) {
            // Print error
            System.out.println(e.getMessage());
        }

        // Return empty object (model)
        return new WhoisData();
    }
}
