import hexlet.code.Differ;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DifferTest {
    @Test
    void differTest() throws Exception {
        String pathToFile1 = "src/test/resources/file1.json";
        String pathToFile2 = "src/test/resources/file2.json";
        String pathToExpectedFixture = "src/test/resources/testDifferPlain.txt";
        String format = "plain";
        String actual = Differ.generate(pathToFile1, pathToFile2, format);
        Path pathToFixture = Paths.get(pathToExpectedFixture);
        String expected = Files.readString(pathToFixture).trim();
        assertEquals(expected, actual);
    }
}
