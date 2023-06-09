package hexlet.code.Formatters;

import java.io.IOException;
import hexlet.code.KeyStatus;
import java.util.Map;


public class Stylish {
    public static String format(Map<String, KeyStatus> differ) throws IOException {

     //   HashSet<String> countryHashSet = new HashSet<>();
        StringBuilder str = new StringBuilder();
        str.append("{\n");
        for (Map.Entry<String, KeyStatus> element : differ.entrySet()) {

            String status = element.getValue().getStatus();
            String key = element.getKey();
            var value1 = element.getValue().getValue1();
            var value2 = element.getValue().getValue2();

            switch (status) {
                case "deleted" -> str.append("  - ").append(key).append(": ").append(value1).append("\n");
                case "added" -> str.append("  + ").append(key).append(": ").append(value2).append("\n");
                case "unchanged" -> str.append("    ").append(key).append(": ").append(value1).append("\n");
                case "changed" -> str.append("  - ").append(key).append(": ").append(value1).
                        append("\n").append("  + ").append(key).append(": ").append(value2).append("\n");
                default -> {
                    return "Something went wrong for input: " + element.getValue();

                    //   sb.append("\n").append("  ");
                    //  if (element.get("status").equals("deleted")) {
                    //     sb.append("- ")
                    //           .append(element.get("key"))
                    //         .append(": ")
                    //         .append(element.get("oldValue"));
                    //    } else if (element.get("status").equals("added")) {
                    //    sb.append("+ ")
                    //         .append(element.get("key"))
                    //        .append(": ")
                    //         .append(element.get("newValue"));
                    //    } else if (element.get("status").equals("unchanged")) {
                    //      sb.append("  ")
                    //             .append(element.get("key"))
                    //             .append(": ")
                    //           .append(element.get("oldValue"));
                    //  } else if (element.get("status").equals("changed")) {
                    //       sb.append("- ")
                    //               .append(element.get("key"))
                    //                .append(": ")
                    //               .append(element.get("oldValue"))
                    //                .append("\n");
                    //        sb.append("  ")
                    //                .append("+ ")
                    //                .append(element.get("key"))
                    //               .append(": ")
                    //               .append(element.get("newValue"));
                }
            }
        }
        str.append("\n}");
        return str.toString().trim();
    }
}
