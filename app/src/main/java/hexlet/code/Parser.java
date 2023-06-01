package hexlet.code;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

public class Parser {
    public static Map<String, Object> typeParser (String StringDir, String content) throws Exception {

        Map<String, Object> map = new HashMap<>();
        ObjectMapper mapper;
        if (StringDir.contains(".json")) {
            mapper = new ObjectMapper();
            map = mapper.readValue(content, Map.class);
        } else if (StringDir.contains(".yaml") || StringDir.contains(".yml")) {
            mapper = new ObjectMapper(new YAMLFactory());
            map = mapper.readValue(content, Map.class);
        }
        return map;
    }
}
