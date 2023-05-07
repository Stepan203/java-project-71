package hexlet.code;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.*;

public class Differ {
    public static String generate(String file_1, String file_2, String format) throws Exception {

        Path map1 = Paths.get(file_1).toAbsolutePath().normalize();
        Path map2 = Paths.get(file_2).toAbsolutePath().normalize();

        String content_1 = Files.readString(map1);
        String content_2 = Files.readString(map2);

        Map<String, Object> maps11 = Parser.typeParser(file_1, content_1);
        Map<String, Object> maps22 = Parser.typeParser(file_2, content_2);

        List<Map<String, Object>> difference = Difference.makeDifference(maps11, maps22);

       // System.out.println(difference.toString());
        return Formatter.choiceFormat(difference, format);
       // return Formatter.choiceFormat(difference, format);
    }
}