package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.*;

public class Differ {
    public static String generate(String file1, String file2, String format) throws Exception {

        Path fullPath1 = Paths.get(file1).toAbsolutePath().normalize();
        Path fullPath2 = Paths.get(file2).toAbsolutePath().normalize();

        String content1 = Files.readString(fullPath1);
        String content2 = Files.readString(fullPath2);

        String[] subStr;
        String delimeter = "\\.";
        subStr = file1.split(delimeter);
        //for(int i = 0; i < subStr.length; i++) {
        System.out.println("Str " + format);
       // }

        Map<String, Object> data1 = Parser.typeParser(file1, content1);
        Map<String, Object> data2 = Parser.typeParser(file2, content2);

        List<Map<String, Object>> difference = Difference.makeDifference(data1, data2);

        System.out.println("File1 " + file1);
        return Formatter.choiceFormat(difference, format);
       // return Formatter.choiceFormat(difference, format);
    }

    public static String generate(String filePath1, String filePath2) throws Exception {
        String format = "stylish";
        return generate(filePath1, filePath2, format);
    }
}