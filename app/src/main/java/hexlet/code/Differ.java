package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;


public class Differ {
    public static String getFileContent(String path) throws IOException {
        Path pathToFile = Paths.get(path).toAbsolutePath().normalize();
        return Files.readString(pathToFile);
    }

    public static ObjectMapper getMapper(String path) {
        String[] pathParts = path.split("\\.");
        String format = pathParts[pathParts.length - 1];
        return switch (format) {
            case "json" -> new ObjectMapper();
            case "yml" -> new YAMLMapper();
            default -> throw new IllegalStateException("Unexpected format: " + format);
        };
    }

    public static String generate(String filePath1, String filePath2) throws Exception {
        return generate(filePath1, filePath2, "stylish");
    }
    public static String generate(String path1, String path2, String format) throws Exception {
        Map<String, Object> file1 = Parser.getMapFromFile(getFileContent(path1), getMapper(path1));
        Map<String, Object> file2 = Parser.getMapFromFile(getFileContent(path2), getMapper(path2));
        List<DifferStatusData> changesLog = DifferCalculator.getListOfDifferences(file1, file2);
        return Formatter.formatOption(format, changesLog);
    }
}
