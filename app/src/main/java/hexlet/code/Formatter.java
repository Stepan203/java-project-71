package hexlet.code;

import java.util.Map;
import hexlet.code.Formatters.Json;
import hexlet.code.Formatters.Plain;
import hexlet.code.Formatters.Stylish;

public class Formatter {

    public static String choiceFormat(Map<String, KeyStatus> difference, String format) throws Exception {
        return switch (format) {
            case "stylish" -> Stylish.format(difference);
            case "plain" -> Plain.createPlain(difference);
            case "json" -> Json.createJson(difference);
            default -> throw new Exception("Wrong format: " + format);
        };
    }
}
