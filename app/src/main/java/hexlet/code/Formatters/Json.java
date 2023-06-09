package hexlet.code.Formatters;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.databind.ObjectMapper;
import hexlet.code.KeyStatus;

public class Json {
    public static String createJson(Map<String, KeyStatus> difference) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String result = mapper.writeValueAsString(difference);
        return result;
    }
}
