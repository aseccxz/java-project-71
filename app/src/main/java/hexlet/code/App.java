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
import java.util.concurrent.Callable;

@Command(name = "gendiff", version = "App 1.0", mixinStandardHelpOptions = true,
        description = "Compares two configuration files and shows a difference.")

public class App implements Runnable {
    //@Option(names = "-c", description = "create a new archive")
    @Parameters(paramLabel = "filepath1", description = "path to first file")
    String path1;
    @Parameters(paramLabel = "filepath2", description = "path to second file")
    String path2;
   /* @Option(names = { "-f", "--file" }, paramLabel = "format", description = "output format [default: stylish]")
*/
    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
    @Override
    public void run() {
        Path pathToFile1 = Paths.get(path1).toAbsolutePath().normalize();
        Path pathToFile2 = Paths.get(path2).toAbsolutePath().normalize();
        Map<String, String> json1 = null;
        try {
            json1 = getMapFromJSON(pathToFile1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Map<String, String> json2 = null;
        try {
            json2 = getMapFromJSON(pathToFile2);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        String result = Differ.generate(json1, json2);
        System.out.println(result);
    }
    //to do to callable
   /* @Override
    public int call() {
        try {
            fileParse();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return 1;
    }*/

    public void fileParse() throws Exception {

    }

    public Map <String, String> getMapFromJSON (Path path) throws Exception {
        String jsonContent = Files.readString(path);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(jsonContent, new TypeReference<Map<String, String>>() { });

    }
}
