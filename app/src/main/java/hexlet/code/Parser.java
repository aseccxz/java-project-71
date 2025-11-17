package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class Parser {
    public static Map<String, Object> getMapFromJSONPath(String path) throws Exception {
        String[] pathParts = path.split("\\.");
        String format = pathParts[pathParts.length - 1];
        Path pathToFile = Paths.get(path).toAbsolutePath().normalize();
        String content = Files.readString(pathToFile);
        ObjectMapper mapper = switch (format) {
            case "json" -> new ObjectMapper();
            case "yml" -> new YAMLMapper();
            default -> throw new IllegalStateException("Unexpected format: " + format);
        };
        return mapper.readValue(content, new TypeReference<Map<String, Object>>() { });
    }
}
