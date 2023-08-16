package videocall.janus.januswebsocket.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;


public class JsonUtil {
    static private Logger logger = LoggerFactory.getLogger(JsonUtil.class);


    private static final ObjectMapper mapper = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            .configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true)
            .setSerializationInclusion(JsonInclude.Include.NON_NULL);

    public static String getJson(Object obj) {
        try {
            return mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            logger.warn("An exception occurred", e);
            throw new RuntimeException(e);
        }
    }

    public static <T> T getObject(byte[] json, Class<T> classOfT) {
        try {
            return mapper.readValue(new String(json, StandardCharsets.UTF_8), classOfT);
        } catch (IOException e) {
            logger.warn("An exception occurred", e);
            throw new RuntimeException(e);
        }
    }

    public static JsonNode getJsonObject(String json) {
        try {
//            logger.warn("json = " + json);
            return json == null ? null : mapper.readTree(json);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
