package hexlet.code;

import java.util.Map;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;


public class Parser {
    public static Map<String, Object> parse(String extension, String content) throws Exception {

      //  Map<String, Object> map = new HashMap<>();
      //  ObjectMapper mapper;
      //  if (stringDir.contains(".json")) {
      //      mapper = new ObjectMapper();
      //      map = mapper.readValue(content, Map.class);
      //  } else if (stringDir.contains(".yaml") || stringDir.contains(".yml")) {
      //      mapper = new ObjectMapper(new YAMLFactory());
      //      map = mapper.readValue(content, Map.class);
      //  }
      //  return map;

        switch (extension) {
            case "json":
                ObjectMapper mapper;
                mapper = new ObjectMapper();
                return mapper.readValue(content, Map.class);
            case "yml":
            case "yaml":
               // ObjectMapper mapper;
                mapper = new ObjectMapper(new YAMLFactory());
                return mapper.readValue(content, Map.class);
            default:
                throw new RuntimeException("No parser for extension: " + extension);
        }
    }
}
