package hexlet.code.Formatters;

import hexlet.code.KeyStatus;
import java.lang.reflect.Array;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Plain {
    public static String createPlain(Map<String, KeyStatus> differ) throws IOException {
        StringBuilder str = new StringBuilder();
        for (Map.Entry<String, KeyStatus> element : differ.entrySet()) {
            /* if (element.get("status").equals("deleted")) {
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
        }*/

            String status = element.getValue().getStatus();
            String key = element.getKey();
            var value1 = element.getValue().getValue1();
            var value2 = element.getValue().getValue2();

            var valueResult1 = prepareValues(value1);
            var valueResult2 = prepareValues(value2);

            switch (status) {
                case "deleted" -> str.append("Property " + "'").append(key).append("'").append(" was removed")
                        .append("\n");
                case "added" -> str.append("Property " + "'").append(key).append("'").append(" was added with value: ")
                        .append(valueResult2).append("\n");
                case "changed" -> str.append("Property " + "'").append(key).append("'").append(" was updated. ")
                        .append("From ").append(valueResult1).append(" to ").append(valueResult2).append("\n");
                case "unchanged" -> { }
                default -> {
                    return "Something went wrong for input: " + element.getValue();
                }
            }
        }
        return str.toString().trim();
    }
    private static String prepareValues(Object value) {

        if (value instanceof String) {
            return "'" + value + "'";
        } else if (value instanceof Map || value instanceof Array || value instanceof List) {
            return "[complex value]";
        } else if (value == null) {

            return "null";
        }
        return String.valueOf(value);
    }
}
