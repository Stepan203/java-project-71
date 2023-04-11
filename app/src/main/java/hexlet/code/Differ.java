package hexlet.code;
import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.*;

public class Differ {

    public static Object generate(String s) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> file1 = objectMapper.readValue(new File("file1.json"), Map.class);
        Map<String, Object> file2 = objectMapper.readValue(new File("file2.json"), Map.class);
        for (Map.Entry<String, Object> pair : file1.entrySet()) {
            if (!file2.containsKey(pair.getKey())) {
                System.out.println("- " + pair.getKey() + ": " + pair.getValue());
            }
            if (file2.containsKey(pair.getKey()) && file2.containsValue(pair.getValue())) {
                System.out.println(pair.getKey() + ": " + pair.getValue());
            }
        }
            for(Map.Entry<String, Object> pair2: file2.entrySet()) {
                if (!file1.containsKey(pair2.getKey())) {
                    System.out.println("+ " + pair2.getKey() + ": " + pair2.getValue());
                }
                if (file1.containsKey(pair2.getKey()) && !file1.containsValue(pair2.getValue())) {
                    System.out.println("- " + pair2.getKey() + ": " + file1.get(pair2.getKey()));
                    System.out.println("+ " + pair2.getKey() + ": " + pair2.getValue());
                }
            }

           // System.out.println(String.format("Key (name) is: %s, Value (age) is : %s", pair.getKey(), pair.getValue()));
      //  }
      //  System.out.println(file1);
      //  System.out.println(file2);
        return null;
    }
}
