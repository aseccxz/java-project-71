package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
//import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import java.util.concurrent.Callable;

@Command(name = "gendiff", version = "App 1.0", mixinStandardHelpOptions = true,
        description = "Compares two configuration files and shows a difference.")

public final class App implements Callable<Integer> {
    //@Option(names = "-c", description = "create a new archive")
    @Parameters(paramLabel = "filepath1", description = "path to first file")
    private String path1;
    @Parameters(paramLabel = "filepath2", description = "path to second file")
    private String path2;
   //@Option(names = { "-f", "--file" }, paramLabel = "format", description = "output format [default: stylish]")

    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
    @Override
    public Integer call() throws Exception {
        String result = Differ.generate(path1, path2);
        System.out.println(result);
        return 0;
    }


}
