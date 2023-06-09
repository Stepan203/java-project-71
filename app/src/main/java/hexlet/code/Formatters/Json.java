package hexlet.code.Formatters;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Json {
    public static String createJson(List<Map<String, Object>> difference) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString((List<Map<String, Object>>) difference);
        //return result;
    }
}
