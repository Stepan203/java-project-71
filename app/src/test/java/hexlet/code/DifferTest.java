package hexlet.code;

//import static com.sun.org.apache.xerces.internal.util.PropertyState.is;
import static org.assertj.core.api.Assertions.assertThat;
//import com.sun.org.apache.xerces.internal.util.PropertyState;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.skyscreamer.jsonassert.JSONAssert;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@SuppressWarnings("unchecked")
public class DifferTest {
    private static String resultStylish;
    private static String resultPlain;
    private static String resultJson;

    private static Path getFixturePath(String fileName) {
        return Paths.get("src", "test", "resources", fileName)
                .toAbsolutePath().normalize();
    }

    private static String getFixtureContent(String fileName) throws Exception {
        Path filePath = getFixturePath(fileName);
        return Files.readString(filePath).trim().replaceAll("\r", "");
    }

    @BeforeAll
    public static void beforeAll() throws Exception {
        resultStylish = getFixtureContent("fixtures/result_stylish.txt");
        resultPlain = getFixtureContent("fixtures/result_plain.txt");
        resultJson = getFixtureContent("fixtures/result_json.json");
    }

    @ParameterizedTest
        @ValueSource(strings = {"json", "yaml"})
    public void generateTest(String format) throws Exception {
        String filePath1 = getFixturePath("file1." + format).toString();
        String filePath2 = getFixturePath("file2." + format).toString();

        // Json and Yaml to stylish as default
        assertThat(Differ.generate(filePath1, filePath2))
                .isEqualTo(resultStylish);
        // Json and Yaml to stylish
        assertThat(Differ.generate(filePath1, filePath2, "stylish"))
                .isEqualTo(resultStylish);
        // Json and Yaml to plain
        assertThat(Differ.generate(filePath1, filePath2, "plain"))
                .isEqualTo(resultPlain);
        // Json and Yaml to json
        assertThat(Differ.generate(filePath1, filePath2, "json"))
                .isEqualTo(resultJson);

        String actualJson = Differ.generate(filePath1, filePath2, "json");
        JSONAssert.assertEquals(resultJson, actualJson, false);
    }
}
