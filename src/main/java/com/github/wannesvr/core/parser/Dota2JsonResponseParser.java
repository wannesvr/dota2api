package com.github.wannesvr.core.parser;

import com.github.wannesvr.core.exception.Dota2ApiException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j;

/**
 * Class containing a single utility method to parse the Steam Web API responses.
 */

@Log4j
@SuppressWarnings("unchecked")
public class Dota2JsonResponseParser implements Dota2ResponseParser {
    private final ObjectMapper mapper = new ObjectMapper();

    /**
     *
     * @param json the json string
     * @param clazz the class to convert to
     * @param <T> type information
     * @return an object of type T
     * @throws Dota2ApiException if parsing fails
     */
    @Override
    public <T> T parse(String json, Class clazz) throws Dota2ApiException {
        try {
            JsonNode node = mapper.readTree(json);
            JsonNode result = node.get("result");
            return (T) mapper.convertValue(result, clazz);
        } catch (Exception e) {
            log.error("Couldn't parse " + json + " to " + clazz.getName());
            throw new Dota2ApiException("Couldn't parse " + json + " to " + clazz.getName());
        }
    }
}
