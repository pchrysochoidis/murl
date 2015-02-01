package main.java.com.tinyurl.myurl.api;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Base class for REST services.
 * 
 * @author leontin_birsan
 */
public abstract class BaseService {

    protected static final String SERVICE_EXCEPTION = "Service exception detected";

    protected static final int HTTP_STATUS_OK = 200;
    protected static final int HTTP_STATUS_BAD_REQUEST = 400;
    protected static final int HTTP_STATUS_SERVER_ERROR = 500;

    protected static final String ERROR_CODES_JSON_PARSE_ERROR = "E_JSON_PARSE";
    protected static final String ERROR_CODES_IO_ERROR = "E_IO";

    private static final Logger LOGGER = Logger.getLogger(BaseService.class.getName());
    private static final String ERROR_PARSIN_JSON = "Error parsing JSON";

    /**
     * Gets the JSON string from the input stream
     * 
     * @param inputStream
     *            the input stream from the request
     * @return the JSON string
     */
    protected String getJSON(InputStream inputStream) {
        StringBuilder crunchifyBuilder = new StringBuilder();

        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
            String line = null;
            while ((line = in.readLine()) != null) {
                crunchifyBuilder.append(line);
            }
        } catch (Exception e) {
            LOGGER.log(Level.FINEST, ERROR_PARSIN_JSON, e);
        }

        return crunchifyBuilder.toString();
    }
    
  
}