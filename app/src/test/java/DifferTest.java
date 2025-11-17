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
        String format1 = "plain";
        String actual = Differ.generate(pathToFile1, pathToFile2, format1);
        Path pathToFixture = Paths.get(pathToExpectedFixture);
        String expected = Files.readString(pathToFixture).trim();
        assertEquals(expected, actual);

        String format2 = "stylish";
        actual = Differ.generate(pathToFile1, pathToFile2, format2);
        pathToExpectedFixture = "src/test/resources/testDifferStylish.txt";
        pathToFixture = Paths.get(pathToExpectedFixture);
        expected = Files.readString(pathToFixture).trim();
        assertEquals(expected, actual);

        String format3 = "json";
        actual = Differ.generate(pathToFile1, pathToFile2, format3);
        pathToExpectedFixture = "src/test/resources/testDifferJson.txt";
        pathToFixture = Paths.get(pathToExpectedFixture);
        expected = Files.readString(pathToFixture).trim();
        assertEquals(expected, actual);
    }
}
