package hexlet.code.formatters;

import java.io.IOException;
import java.util.Map;
import com.fasterxml.jackson.databind.ObjectMapper;
import hexlet.code.KeyStatus;
public class Json {
    public static String format(Map<String, KeyStatus> difference) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String result = mapper.writeValueAsString(difference);
        return result;
    }
}
