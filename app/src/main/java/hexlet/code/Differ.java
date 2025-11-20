package hexlet.code;

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

    public static String getFileExtension(String path) {
        String[] pathParts = path.split("\\.");
        return pathParts[pathParts.length - 1];
    }

    public static String getFormatByExtension(String path) {
        String extension = getFileExtension(path);
        return switch (extension) {
            case "json" -> "json";
            case "yml", "yaml" -> "yml";
            default -> throw new IllegalStateException("Unexpected file extension: " + extension);
        };
    }

    public static String generate(String path1, String path2, String format) throws Exception {
        Map<String, Object> data1 = Parser.getMap(getFileContent(path1), getFormatByExtension(path1));
        Map<String, Object> data2 = Parser.getMap(getFileContent(path2), getFormatByExtension(path2));
        List<DifferStatusData> changesLog = DifferCalculator.getListOfDifferences(data1, data2);
        return Formatter.formatOption(format, changesLog);
    }
    public static String generate(String filePath1, String filePath2) throws Exception {
        return generate(filePath1, filePath2, "stylish");
    }
}
