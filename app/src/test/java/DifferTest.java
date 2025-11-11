import hexlet.code.Differ;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifferTest {
    @Test
    public void differTest() throws Exception {
        String pathToFile1 = "src/test/resources/file1.json";
        String pathToFile2 = "src/test/resources/file2.json";
        String actual = Differ.generate(pathToFile1, pathToFile2);
        String expected = """
        - follow: false
          host: hexlet.io
        - proxy: 123.234.53.22
        - timeout: 50
        + timeout: 20
        + verbose: true
            """;
        assertEquals(expected, actual);
    }
}
