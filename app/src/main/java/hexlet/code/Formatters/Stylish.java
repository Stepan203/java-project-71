package hexlet.code.Formatters;

import java.io.IOException;


import java.util.List;
import java.util.Map;


public class Stylish {
    public static String format(List<Map<String, Object>> differ) throws IOException {

     //   HashSet<String> countryHashSet = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (Map<String, Object> element : differ) {
            sb.append("\n").append("  ");
            if (element.get("status").equals("deleted")) {
                sb.append("- ")
                        .append(element.get("key"))
                        .append(": ")
                        .append(element.get("oldValue"));
            } else if (element.get("status").equals("added")) {
                sb.append("+ ")
                        .append(element.get("key"))
                        .append(": ")
                        .append(element.get("newValue"));
            } else if (element.get("status").equals("unchanged")) {
                sb.append("  ")
                        .append(element.get("key"))
                        .append(": ")
                        .append(element.get("oldValue"));
            } else if (element.get("status").equals("changed")) {
                sb.append("- ")
                        .append(element.get("key"))
                        .append(": ")
                        .append(element.get("oldValue"))
                        .append("\n");
                sb.append("  ")
                        .append("+ ")
                        .append(element.get("key"))
                        .append(": ")
                        .append(element.get("newValue"));
            }
        }
        sb.append("\n}");
        return sb.toString().trim();
    }
}
