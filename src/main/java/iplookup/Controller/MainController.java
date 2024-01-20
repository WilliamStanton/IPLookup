package iplookup.Controller;

import iplookup.Model.IpAddressData;
import iplookup.Model.WhoisData;
import iplookup.Service.IpLookupService;
import iplookup.Service.RemoteAddrService;
import iplookup.Service.WhoisLookupService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MainController {
    // Initialize Service
    private final IpLookupService ipLookupService;
    private final WhoisLookupService whoisLookupService;
    private final RemoteAddrService remoteAddrService;

    public MainController(IpLookupService ipLookupService, WhoisLookupService whoisLookupService, RemoteAddrService remoteAddrService) {
        this.ipLookupService = ipLookupService;
        this.whoisLookupService = whoisLookupService;
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
        IpAddressData data = ipLookupService.lookUp(ip);

        // Send requested lookup data
        model.addAttribute("ipData", data);

        // Return lookup page
        return "lookup.html";
    }

    @GetMapping("/whois/{domain}")
    public String lookupDomain(@PathVariable String domain, Model model) {
        // Lookup Domain
        WhoisData data = whoisLookupService.lookUp(domain);

        // Send requested whois data
        model.addAttribute("admin", data.getAdmin());
        model.addAttribute("admin", data.getBilling());
        model.addAttribute("admin", data.getRegistrant());
        model.addAttribute("admin", data.getRegistrar());



        // Return whois page
        return "whois.html";
    }
}
