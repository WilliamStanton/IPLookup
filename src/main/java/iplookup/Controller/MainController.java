package iplookup.Controller;

import iplookup.Model.IpData;
import iplookup.Service.IpLookupService;
import iplookup.Service.RemoteAddrService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MainController {
    // Initialize Service
    private final IpLookupService ipLookupService;
    private final RemoteAddrService remoteAddrService;

    public MainController(IpLookupService ipLookupService, RemoteAddrService remoteAddrService) {
        this.ipLookupService = ipLookupService;
        this.remoteAddrService = remoteAddrService;
    }

    /**
     * The home GET method returns the homepage alongside attributes to show
     * the client their data
     * @param request obtains the clients IP Address
     * @param model attributes containing client data
     * @return home page
     */
    @GetMapping("/")
    public String home(HttpServletRequest request, Model model) {
        // Obtain client IP Address
        var ip = remoteAddrService.getClientIp(request);

        // Send client their data
        model.addAttribute("clientData", ipLookupService.lookUp(ip));

        // Return home page
        return "home.html";
    }

    /**
     * The lookupIP GET method returns the lookup page
     * along with the attributes to show the lookup data
     * @param ip the requested IP
     * @param model attributes containing requested lookup data
     * @return ip lookup page
     */
    @GetMapping ("/iplookup/{ip}")
    public String lookupIp(@PathVariable String ip, Model model) {
        // Lookup IP
        IpData data = ipLookupService.lookUp(ip);

        // Send requested lookup data
        model.addAttribute("ipData", data);

        // Return lookup page
        return "lookup.html";
    }
}
