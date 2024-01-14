package iplookup.Service;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;

@Service
public class RemoteAddrService {
    /**
     * The getClientIp method gets the client IP Address from either cloudflare headers or
     * default headers
     * @param request HTTP Request
     * @return client IP Address
     */
    public String getClientIp(HttpServletRequest request) {
        // Initialize Variable
        String remoteAddr = "";

        // Get IP from determined headers
        if (request != null) {
            remoteAddr = request.getHeader("X-FORWARDED-FOR");
            if (remoteAddr == null || "".equals(remoteAddr)) {
                remoteAddr = request.getRemoteAddr();
            }
        }

        // Return IP Address
        return remoteAddr;
    }
}
