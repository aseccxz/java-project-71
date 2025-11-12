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
        Path pathToFile = Paths.get(path).toAbsolutePath().normalize();
        String jsonContent = Files.readString(pathToFile);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(jsonContent, new TypeReference<Map<String, Object>>() { });
    }
    public static Map<String, Object> getMapFromYAMLPath(String path) throws Exception {
        Path pathToFile = Paths.get(path).toAbsolutePath().normalize();
        String yamlContent = Files.readString(pathToFile);
        ObjectMapper mapper = new YAMLMapper();
        return mapper.readValue(yamlContent, new TypeReference<Map<String, Object>>() { });
    }
}
