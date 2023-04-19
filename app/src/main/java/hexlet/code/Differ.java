package hexlet.code;
import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.*;

public class Differ {
    public static String generate(String file_1, String file_2) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> file1 = objectMapper.readValue(new File("file1.json"), Map.class);
        Map<String, Object> file2 = objectMapper.readValue(new File("file2.json"), Map.class);
        HashSet<String> countryHashSet = new HashSet<>();
        Map<String, Object> lhm = new TreeMap<String, Object>();
        StringBuilder sb = new StringBuilder("{ \n");
        for (Map.Entry<String, Object> pair1 : file1.entrySet()) {
            countryHashSet.add(pair1.getKey());
        }
        for (Map.Entry<String, Object> pair2 : file2.entrySet()) {
            countryHashSet.add(pair2.getKey());
        }
        countryHashSet.stream().forEach((keySet) -> {
            lhm.put(keySet, file1.get(keySet));
            lhm.put(keySet, file1.get(keySet));
        });
        for (String key : lhm.keySet()) {
            if (file1.containsKey(key) && !file2.containsKey(key)) {
                sb.append(" - " + key + ": " + lhm.get(key) + "\n");
            }
            if (file1.containsKey(key) && file2.containsKey(key)) {
                if (file1.get(key).equals(file2.get(key)))
                    sb.append(" " + key + ": " + lhm.get(key) + "\n");
            }
            if (file1.containsKey(key) && file2.containsKey(key) && !file1.get(key).equals(file2.get(key))) {
                sb.append(" - " + key + ": " + file1.get(key) + "\n");
                sb.append(" + " + key + ": " + file2.get(key) + "\n");
        }
        if (!file1.containsKey(key) && file2.containsKey(key)) {
            sb.append(" + " + key + ": " + file2.get(key) + "\n");
        }
    }
        sb.append("}");
        return sb.toString();
    }
}