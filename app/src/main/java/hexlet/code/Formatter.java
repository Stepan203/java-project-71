package hexlet.code;

import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.databind.ObjectMapper;
import hexlet.code.Formatters.Json;
import hexlet.code.Formatters.Plain;
import hexlet.code.Formatters.Stylish;

public class Formatter {

    public static String choiceFormat(List<Map<String, Object>> difference, String format) throws Exception {
        return switch (format) {
                case "stylish" -> Stylish.createStylish((List<Map<String, Object>>) difference);
                case "plain" -> Plain.createPlain((List<Map<String, Object>>) difference);
                case "json" -> Json.createJson(difference);
                default -> throw new Exception("Wrong format: " + format);
        };
    }
}
