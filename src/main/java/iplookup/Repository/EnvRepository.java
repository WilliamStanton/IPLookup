package iplookup.Repository;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

/**
 * Provides data from environment variables file
 */
@Repository
public class EnvRepository {
    /**
     * Returns the API Key for the IP2Location Service
     * which must be in an .env file in the project directory
     * @return the IP2Location API Key
     */
    public String getApiKey() {
        // Load ENV File
        Dotenv dotenv = Dotenv.configure().load();

        // Return the IP2Location API Key
        return dotenv.get("api_key");
    }
}
