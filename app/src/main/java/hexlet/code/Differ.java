package hexlet.code;
import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.*;

public class Differ {
    public static LinkedHashMap generate(String file_1, String file_2) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> file1 = objectMapper.readValue(new File("file1.json"), Map.class);
        Map<String, Object> file2 = objectMapper.readValue(new File("file2.json"), Map.class);
        HashSet<String> countryHashSet = new HashSet<>();
        LinkedHashMap lhm = new LinkedHashMap();
        //ArrayList<String> myArrayList = new ArrayList<String>();
        // StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Object> pair : file1.entrySet()) {
            countryHashSet.add(pair.getKey());
            }
        for (Map.Entry<String, Object> pair2 : file2.entrySet()) {
            countryHashSet.add(pair2.getKey());
            }
        countryHashSet.stream().forEach((keySet) -> {
            if (file1.containsKey(keySet) && !file2.containsKey(keySet)) {
                lhm.put(file1.get(keySet), " - " + keySet);
            }
            if (file1.containsKey(keySet) && file2.containsKey(keySet)) {
                if (file1.get(keySet).equals(file2.get(keySet))) {
                    lhm.put(file1.get(keySet), keySet);
                }
                else
                lhm.put(file1.get(keySet), keySet);
                lhm.put(file2.get(keySet), keySet);
            }
            if (!file1.containsKey(keySet) && file2.containsKey(keySet)) {
                lhm.put(file2.get(keySet), " + " + keySet);
            }
        });
        lhm.forEach((key, value) -> System.out.printf((String) value, key));
        return lhm;
    }
}