package hexlet.code;

//import static com.sun.org.apache.xerces.internal.util.PropertyState.is;

//import com.sun.org.apache.xerces.internal.util.PropertyState;
import org.junit.jupiter.api.Test;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("unchecked")
public class DifferTest {

    @Test
    public void assertThat() throws IOException {
       // ObjectMapper objectMapper = new ObjectMapper();
       // Map<String, Object> file1 = objectMapper.readValue(new File("file1.json"), Map.class);
        String expected = "";
        assertEquals(null, Differ.generate("file1.json"));

    }


}
