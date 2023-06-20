package hexlet.code.formatters;

import hexlet.code.KeyStatus;
import java.io.IOException;
import java.util.Map;
import java.util.List;

public class Plain {
    public static String format(Map<String, KeyStatus> differ) throws IOException {
        StringBuilder str = new StringBuilder();
        for (Map.Entry<String, KeyStatus> element : differ.entrySet()) {
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
                case "unchanged" -> {
                }
                default -> {
                    return "Something went wrong for input: " + element.getValue();
                }
            }
        }
        return str.toString().trim();
    }
    private static String prepareValues(Object value) {

       // if (value instanceof String) {
            if (value instanceof Map || value instanceof List) {
                return "[complex value]";
            } else if (value == null) {
                return null;
            } else if (value instanceof String) {
                return "'" + value + "'";
            } else {
                return value.toString();
            }
       // }
    }
}
