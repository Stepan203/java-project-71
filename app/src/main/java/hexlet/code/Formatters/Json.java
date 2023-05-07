package hexlet.code.Formatters;

import hexlet.code.Formatters.Stylish;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Json {
    public static String createJson(List<Map<String, Object>> difference) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String result = mapper.writeValueAsString(Stylish.createStylish((List<Map<String, Object>>) difference));
        return result.trim();
    }
}
