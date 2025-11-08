package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
// some exports omitted for the sake of brevity

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
        String jsonContent1 = Files.readString(pathToFile1);
        String jsonContent2 = Files.readString(pathToFile2);
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Integer> scoreByName1 = mapper.readValue(jsonContent1, Map.class);
        Map<String, Integer> scoreByName2 = mapper.readValue(jsonContent2, Map.class);
        System.out.println("File1: " + scoreByName1);
        System.out.println("File2: " + scoreByName2);
    }
}
