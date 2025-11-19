package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.util.Map;

public class Parser {
    public static ObjectMapper getMapper(String extension) {
        return switch (extension) {
            case "json" -> new ObjectMapper();
            case "yml" -> new YAMLMapper();
            default -> throw new IllegalStateException("Unexpected format: " + extension);
        };
    }
    public static Map<String, Object> getMapFromFile(String content, String extension) throws Exception {
        return getMapper(extension).readValue(content, new TypeReference<Map<String, Object>>() { });
    }
}
