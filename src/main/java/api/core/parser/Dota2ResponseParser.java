package api.core.parser;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

@SuppressWarnings("unchecked")
public class Dota2ResponseParser {
    private static final ObjectMapper mapper = new ObjectMapper();

    public static <T> T parse(String json, Class clazz) throws IOException {
        JsonNode node = mapper.readTree(json);
        JsonNode result = node.get("result");

        return (T) mapper.convertValue(result, clazz);
    }
}
