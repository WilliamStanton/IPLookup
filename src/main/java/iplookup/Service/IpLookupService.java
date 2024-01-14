package iplookup.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import com.ip2location.Configuration;
import com.ip2location.IPGeolocation;
import iplookup.Repository.EnvRepository;
import iplookup.Model.IpData;
import org.springframework.stereotype.Service;

@Service
public class IpLookupService {
    // Initialize Repository
    private final EnvRepository envRespository;

    public IpLookupService(EnvRepository envRespository) {
        this.envRespository = envRespository;
    }


    /**
     * The lookUp method returns an object (model) containing information
     * found regarding the IP Address entered
     * @param ip the IP Address to look up
     * @return the object (model) holding the IP Information
     */
    public IpData lookUp(String ip) {
        // Initialize Lookup
        Configuration config = new Configuration();
        config.setApiKey(envRespository.getApiKey());
        IPGeolocation ipl = new IPGeolocation(config);

        // Lookup IP Address Data
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Obtain & Map data to object
            JsonObject data = ipl.Lookup(ip);
            IpData results = objectMapper.readValue(data.toString(), IpData.class);

            // Return successful object (model)
            return results;
        } catch(Exception e) {
            // Print error
            System.out.println(e.getMessage());
        }

        // Return empty object (model)
        return new IpData();
    }
}
