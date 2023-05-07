package hexlet.code;

//import static com.sun.org.apache.xerces.internal.util.PropertyState.is;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.params.ParameterizedTest;
//import com.sun.org.apache.xerces.internal.util.PropertyState;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@SuppressWarnings("unchecked")
public class differTest {
    private static String resultStylish;
    private static String resultPlain;
    private static String resultJson;

     @Test
    void testJson() throws Exception {
        String filepath1 = "file1.json";
        Path pathToFile1 = Paths.get(filepath1);
        String filepath2 = "file2.json";
        Path pathToFile2 = Paths.get(filepath2);
        String format = "json";
        String actual = Differ.generate(filepath1, filepath2, format);
        String fileJson = "src/test/java/hexlet/code/result_plain.txt";
        Path map1 = Paths.get(fileJson).toAbsolutePath().normalize();
        String expected = Files.readString(map1);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testYaml() throws Exception {
        String filepath1 = "file1.yaml";
        String filepath2 = "file2.yaml";
        Path pathFile1 = Paths.get(filepath1);
        Path pathFile2 = Paths.get(filepath2);
        String format = "stylish";
        String actual = Differ.generate(filepath1, filepath2, format);
        String fileYaml = "src/test/java/hexlet/code/result_stylish.txt";
        Path map2 = Paths.get(fileYaml).toAbsolutePath().normalize();
        String expected = Files.readString(map2);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testPlain() throws Exception {
        String filepath1 = "file1.json";
        Path pathToFile1 = Paths.get(filepath1);
        String filepath2 = "file2.json";
        Path pathToFile2 = Paths.get(filepath2);
        String format = "plain";
        String actual = Differ.generate(filepath1, filepath2, format);
        String fileJson = "src/test/java/hexlet/code/result_plain.txt";
        Path map1 = Paths.get(fileJson).toAbsolutePath().normalize();
        String expected = Files.readString(map1);
        assertThat(actual).isEqualTo(expected);
    }
}
