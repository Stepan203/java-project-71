package hexlet.code;

import java.util.Map;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;


public class Parser {
    public static Map<String, Object> parse(String extension, String content) throws Exception {

        switch (extension) {
            case "json":
                return new ObjectMapper().readValue(content, Map.class);
            case "yml":
            case "yaml":
                return new ObjectMapper(new YAMLFactory()).readValue(content, Map.class);
            default:
                throw new RuntimeException("No parser for extension: " + extension);
        }
    }
}
