package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import org.apache.commons.collections4.CollectionUtils;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Command(name = "gendiff", version = "App 1.0", mixinStandardHelpOptions = true,
        description = "Compares two configuration files and shows a difference.")

public class App implements Runnable {
    //@Option(names = "-c", description = "create a new archive")
    /*@Parameters(paramLabel = "filepath1", description = "path to first file")
    String path1;
    @Parameters(paramLabel = "filepath2", description = "path to second file")
    String path2;
    @Option(names = { "-f", "--file" }, paramLabel = "format", description = "output format [default: stylish]")
*/
    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
    @Override
    public void run() {
        try {
            fileParse();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static void fileParse() throws Exception {
        Path pathToFile1 = Paths.get("/home/aseccxz/projects/secondProject/java-project-71/app/src/main/java/hexlet/code/file1.json");
        Path pathToFile2 = Paths.get("/home/aseccxz/projects/secondProject/java-project-71/app/src/main/java/hexlet/code/file2.json");

        Map<String, String> json1 = getMapFromJSON(pathToFile1);
        Map<String, String> json2 = getMapFromJSON(pathToFile2);
        differ(json1, json2);

    }
    public static void differ(Map <String, String> json1, Map <String, String> json2) {
        Set<String> keysJson1 = json1.keySet();
        Set<String> keysJson2 = json2.keySet();
        List<String> allKeys = (List<String>) CollectionUtils.union(keysJson1, keysJson2);
        List<String> commonKeys = (List<String>) CollectionUtils.intersection(keysJson1, keysJson2);
        List<String> uniqueKeysJson1 = (List<String>) CollectionUtils.subtract(keysJson1, keysJson2);
        List<String> uniqueKeysJson2 = (List<String>) CollectionUtils.subtract(keysJson2, keysJson1);
        StringBuilder diff = new StringBuilder();
        allKeys.sort(String::compareTo);
        allKeys.forEach(key ->{
            if (commonKeys.contains(key)) {
                if (json1.get(key).equals(json2.get(key))) {
                    diff.append("  ").append(key).append(": ").append(json1.get(key)).append("\n");
                } else {
                    diff.append("- ").append(key).append(": ").append(json1.get(key)).append("\n");
                    diff.append("+ ").append(key).append(": ").append(json2.get(key)).append("\n");
                }
            }
            if (uniqueKeysJson1.contains(key)) {
                diff.append("- ").append(key).append(": ").append(json1.get(key)).append("\n");
            }
            if (uniqueKeysJson2.contains(key)) {
                diff.append("+ ").append(key).append(": ").append(json2.get(key)).append("\n");
            }
        });
        System.out.println(diff.toString());
    }
    public static Map <String, String> getMapFromJSON (Path path) throws Exception {
        String jsonContent = Files.readString(path);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(jsonContent, new TypeReference<Map<String, String>>() { });

    }
}
