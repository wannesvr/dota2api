package api.core.parser;

import api.core.exception.Dota2ApiException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j;

import java.io.IOException;

/**
 * Class containing a single utility method to parse the Steam Web API responses.
 */

@Log4j
@SuppressWarnings("unchecked")
public class Dota2ResponseParser {
    private static final ObjectMapper mapper = new ObjectMapper();

    /**
     *
     * @param json the json string
     * @param clazz the class to convert to
     * @param <T> type information
     * @return an object of type T
     * @throws Dota2ApiException if parsing fails
     */
    public static <T> T parse(String json, Class clazz) throws Dota2ApiException {
        JsonNode node = null;
        try {
            node = mapper.readTree(json);
            JsonNode result = node.get("result");
            return (T) mapper.convertValue(result, clazz);
        } catch (Exception e) {
            log.error("Couldn't parse " + json + " to " + clazz.getName());
            throw new Dota2ApiException("Couldn't parse " + json + " to " + clazz.getName());
        }
    }
}
