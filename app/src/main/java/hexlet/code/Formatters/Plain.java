package hexlet.code.Formatters;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Plain {
    public static String createPlain(List<Map<String, Object>> differ) throws IOException {
        StringBuilder plain = new StringBuilder();
        for (Map<String, Object> element : differ) {
            if (element.get("status").equals("deleted")) {
                plain.append("Property '")
                        .append(element.get("key"))
                        .append("' was removed")
                        .append("\n");
            } else if (element.get("status").equals("added")) {
                plain.append("Property '")
                        .append(element.get("key"))
                        .append("' was added with value: ")
                        .append(checkValue(element.get("newValue")))
                        .append("\n");
            } else if (element.get("status").equals("changed")) {
                plain.append("Property '")
                        .append(element.get("key"))
                        .append("' was updated. From ")
                        .append(checkValue(element.get("oldValue")))
                        .append(" to ")
                        .append(checkValue(element.get("newValue")))
                        .append("\n");
            }
        }
        return plain.toString().trim();
    }
    public static String checkValue(Object value) {
        if (value instanceof Map || value instanceof List) {
            return "[complex value]";
        } else if (value == null) {
            return null;
        } else if (value instanceof String) {
            return "'" + value + "'";
        } else {
            return value.toString();
        }
    }
}
