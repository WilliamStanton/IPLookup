package iplookup.Service;

import iplookup.Model.IpData;
import iplookup.Proxy.Ip2LocationProxy;
import iplookup.Repository.EnvRepository;
import org.springframework.stereotype.Service;

/**
 * Utilizes the IP2Location Proxy and EnvRepository to send authenticated requests to the api
 */
@Service
public class Ip2LocationService {
    private final Ip2LocationProxy ip2LocationProxy;
    private final EnvRepository envRepository;

    public Ip2LocationService(Ip2LocationProxy ip2LocationProxy, EnvRepository envRepository) {
        this.ip2LocationProxy = ip2LocationProxy;
        this.envRepository = envRepository;
    }

    /**
     * Gets ip data for a specified ip address
     * @param ip the ip address
     * @return ip data
     */
    public IpData ipLookup(String ip) {
        return ip2LocationProxy.ipLookup(ip, envRepository.getApiKey());
    }
}
