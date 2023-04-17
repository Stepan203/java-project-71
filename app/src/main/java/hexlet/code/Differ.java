package hexlet.code;
import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.*;

public class Differ {

    public static ArrayList<String> generate(String file_1, String file_2) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> file1 = objectMapper.readValue(new File("file1.json"), Map.class);
        Map<String, Object> file2 = objectMapper.readValue(new File("file2.json"), Map.class);
        ArrayList<String> myArrayList = new ArrayList<String>();
        // StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Object> pair : file1.entrySet()) {
            if (!file2.containsKey(pair.getKey())) {
                myArrayList.add(pair.getKey());
                myArrayList.add(pair.getValue().toString());
                //  sb.append(pair.getKey());
                // sb.append(pair.getValue());
                // System.out.println("- " + pair.getKey() + ": " + pair.getValue());
                 System.out.println("arr1_1 " + myArrayList);
            }
            if (file2.containsKey(pair.getKey()) && file2.containsValue(pair.getValue())) {
                myArrayList.add(pair.getKey());
                myArrayList.add(pair.getValue().toString());
                //sb.append(pair.getKey());
                //sb.append(pair.getValue());
                System.out.println("arr1_2" + myArrayList);
                // System.out.println(pair.getKey() + ": " + pair.getValue());
                // System.out.println(pair.getKey() + ": " + pair.getValue());
            }
        }
        for (Map.Entry<String, Object> pair2 : file2.entrySet()) {
            if (!file1.containsKey(pair2.getKey())) {
                myArrayList.add(pair2.getKey());
                myArrayList.add(pair2.getValue().toString());
                System.out.println("arr2_1" + myArrayList);
                //   sb.append(pair2.getKey());
                //   sb.append(pair2.getValue());
                //   System.out.println("+ " + pair2.getKey() + ": " + pair2.getValue());
            }
            if (file1.containsKey(pair2.getKey()) && !file1.containsValue(pair2.getValue())) {
                myArrayList.add(pair2.getKey());
                myArrayList.add(pair2.getValue().toString());
                myArrayList.add(file1.get(pair2.getKey()).toString());
                System.out.println("arr2_2" + myArrayList);
                // sb.append(pair2.getKey());
                // sb.append(pair2.getValue());
                //  System.out.println("- " + pair2.getKey() + ": " + file1.get(pair2.getKey()));
                //   System.out.println("+ " + pair2.getKey() + ": " + pair2.getValue());
                //  System.out.println("- " + pair2.getKey() + ": " + file1.get(pair2.getKey()));
                //System.out.println("+ " + pair2.getKey() + ": " + pair2.getValue());
            }
        }
        return myArrayList;
    }
}