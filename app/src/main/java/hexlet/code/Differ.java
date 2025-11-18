package hexlet.code;

import java.util.List;
import java.util.Map;


public class Differ {
    /*public static String getFileContent(){
        String[] pathParts = path.split("\\.");
        String format = pathParts[pathParts.length - 1];
        Path pathToFile = Paths.get(path).toAbsolutePath().normalize();
        String content = Files.readString(pathToFile);
    }*/

    public static String generate(String filePath1, String filePath2) throws Exception {
        return generate(filePath1, filePath2, "stylish");
    }
    public static String generate(String pathJson1, String pathJson2, String format) throws Exception {
        Map<String, Object> file1 = Parser.getMapFromJSONPath(pathJson1);
        Map<String, Object> file2 = Parser.getMapFromJSONPath(pathJson2);
        List<DifferStatusData> changesLog = DifferCalculator.getListOfDifferences(file1, file2);
        return Formatter.formatOption(format, changesLog);
    }
}
