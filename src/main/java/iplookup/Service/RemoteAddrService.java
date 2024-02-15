package iplookup.Service;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;

/**
 * Ensures that IP Address is accurately processed via Cloudflare CDN
 */
@Service
public class RemoteAddrService {
    /**
     * Obtains the client IP Address from relevant headers (either cloudflare headers or default headers)
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
