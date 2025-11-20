package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.util.Map;

public class Parser {
    public static ObjectMapper getMapper(String format) {
        return switch (format) {
            case "json" -> new ObjectMapper();
            case "yml" -> new YAMLMapper();
            default -> throw new IllegalStateException("Unexpected format: " + format);
        };
    }
    public static Map<String, Object> getMap(String content, String format) throws Exception {
        return getMapper(format).readValue(content, new TypeReference<Map<String, Object>>() { });
    }
}
