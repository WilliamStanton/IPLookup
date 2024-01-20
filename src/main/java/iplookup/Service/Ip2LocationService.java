package iplookup.Service;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import iplookup.Repository.EnvRepository;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class Ip2LocationService {
    private final EnvRepository envRepository;

    public Ip2LocationService(EnvRepository envRepository) {
        this.envRepository = envRepository;
    }

    public JsonObject getIp(String ip) {
        JsonObject data = new JsonObject();
        try {
            // Connect to API
            URL url = new URL("https://api.ip2location.io/?key=" + envRepository.getApiKey() + "&ip=" + ip);
            HttpURLConnection request = (HttpURLConnection) url.openConnection();
            request.connect();

            // Get JSON Object
            JsonParser jp = new JsonParser();
            JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
            data = root.getAsJsonObject();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return data;
    }

    public JsonObject getWhois(String domain) {
        JsonObject data = new JsonObject();
        try {
            // Connect to API
            URL url = new URL("https://api.ip2whois.com/v2?key=" + envRepository.getApiKey() + "&domain=" + domain);
            HttpURLConnection request = (HttpURLConnection) url.openConnection();
            request.connect();

            // Get JSON Object
            JsonParser jp = new JsonParser();
            JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
            data = root.getAsJsonObject();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return data;
    }
}
