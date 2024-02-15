package iplookup.Controller;

import iplookup.Service.Ip2LocationService;
import iplookup.Service.RemoteAddrService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * MVC Controller
 */
@EnableFeignClients(basePackages = "iplookup.Proxy")
@Controller
public class MainController {
    // Initialize Service
    private final RemoteAddrService remoteAddrService;
    private final Ip2LocationService ip2LocationService;

    public MainController(RemoteAddrService remoteAddrService, Ip2LocationService ip2LocationService) {
        this.remoteAddrService = remoteAddrService;
        this.ip2LocationService = ip2LocationService;
    }

    /**
     * Returns the homepage alongside attributes to show
     * the client their data
     * @param request obtains the clients IP Address
     * @param model attributes containing client data
     * @return home page
     */
    @GetMapping("/")
    public String home(HttpServletRequest request, Model model) {
        // Obtain client IP Address & send client data
        model.addAttribute("clientData", ip2LocationService.ipLookup(remoteAddrService.getClientIp(request)));

        // Return home page
        return "home.html";
    }

    /**
     * Returns the lookup page
     * along with the attributes to show the lookup data
     * @param ip the requested IP
     * @param model attributes containing requested lookup data
     * @return ip lookup page
     */
    @GetMapping ("/iplookup/{ip}")
    public String lookupIp(@PathVariable String ip, Model model) {
        // Lookup IP & send requested lookup data
        model.addAttribute("ipData", ip2LocationService.ipLookup(ip));

        // Return lookup page
        return "lookup.html";
    }
}
