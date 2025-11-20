import hexlet.code.Differ;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DifferTest {
    private final String pathToJson1 = "src/test/resources/file1.json";
    private final String pathToJson2 = "src/test/resources/file2.json";
    private final String pathToYml1 = "src/test/resources/file1.yml";
    private final String pathToYml2 = "src/test/resources/file2.yml";
    @Test
    void differTestJsonPlain() throws Exception {

        String pathToExpectedFixture = "src/test/resources/testDifferPlain.txt";
        String format1 = "plain";
        String actual = Differ.generate(pathToJson1, pathToJson2, format1);
        Path pathToFixture = Paths.get(pathToExpectedFixture);
        String expected = Files.readString(pathToFixture).trim();
        assertEquals(expected, actual);
    }
    @Test
    void differTestJsonStylish() throws Exception {
        String format2 = "stylish";
        String actual = Differ.generate(pathToJson1, pathToJson2, format2);
        String pathToExpectedFixture = "src/test/resources/testDifferStylish.txt";
        Path pathToFixture = Paths.get(pathToExpectedFixture);
        String expected = Files.readString(pathToFixture).trim();
        assertEquals(expected, actual);
    }
    @Test
    void differTestJsonDefault() throws Exception {
        String actual = Differ.generate(pathToJson1, pathToJson2);
        String pathToExpectedFixture = "src/test/resources/testDifferStylish.txt";
        Path pathToFixture = Paths.get(pathToExpectedFixture);
        String expected = Files.readString(pathToFixture).trim();
        assertEquals(expected, actual);
    }
    @Test
    void differTestJsonJson() throws Exception {
        String format3 = "json";
        String actual = Differ.generate(pathToJson1, pathToJson2, format3);
        String pathToExpectedFixture = "src/test/resources/testDifferJson.txt";
        Path pathToFixture = Paths.get(pathToExpectedFixture);
        String expected = Files.readString(pathToFixture).trim();
        assertEquals(expected, actual);
    }
    @Test
    void differTestYMLPlain() throws Exception {
        String pathToExpectedFixture = "src/test/resources/testDifferPlain.txt";
        String format1 = "plain";
        String actual = Differ.generate(pathToYml1, pathToYml2, format1);
        Path pathToFixture = Paths.get(pathToExpectedFixture);
        String expected = Files.readString(pathToFixture).trim();
        assertEquals(expected, actual);
    }
    @Test
    void differTestYMLStylish() throws Exception {
        String format2 = "stylish";
        String actual = Differ.generate(pathToYml1, pathToYml2, format2);
        String  pathToExpectedFixture = "src/test/resources/testDifferStylish.txt";
        Path pathToFixture = Paths.get(pathToExpectedFixture);
        String expected = Files.readString(pathToFixture).trim();
        assertEquals(expected, actual);
    }
    @Test
    void differTestYMLDefault() throws Exception {
        String actual = Differ.generate(pathToYml1, pathToYml2);
        String pathToExpectedFixture = "src/test/resources/testDifferStylish.txt";
        Path pathToFixture = Paths.get(pathToExpectedFixture);
        String expected = Files.readString(pathToFixture).trim();
        assertEquals(expected, actual);
    }
    @Test
    void differTestYMLJson() throws Exception {
        String format3 = "json";
        String actual = Differ.generate(pathToYml1, pathToYml2, format3);
        String pathToExpectedFixture = "src/test/resources/testDifferJson.txt";
        Path pathToFixture = Paths.get(pathToExpectedFixture);
        String expected = Files.readString(pathToFixture).trim();
        assertEquals(expected, actual);
    }
}
