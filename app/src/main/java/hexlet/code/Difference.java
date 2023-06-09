package hexlet.code;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class Difference {
    public static Map<String, KeyStatus> makeDifference(Map<String, Object> firstMap, Map<String, Object> secondMap) {
        Map<String, KeyStatus> result = new LinkedHashMap<>();//ArrayList<>();

       // Set<String> keys = new TreeSet<>();
      //  keys.addAll(mapA.keySet());
      //  keys.addAll(mapB.keySet());

      //  for (String key : keys) {
      //      Map<String, Object> diffMap = new TreeMap<>();
      //      var valueA = mapA.get(key);
      //      var valueB = mapB.get(key);

      //      if (mapA.containsKey(key) && !mapB.containsKey(key)) {
      //          diffMap.put("key", key);
      //          diffMap.put("status", "deleted");
      //          diffMap.put("oldValue", valueA);
      //      } else if (!mapA.containsKey(key) && mapB.containsKey(key)) {
      //          diffMap.put("key", key);
      //          diffMap.put("status", "added");
      //          diffMap.put("newValue", mapB.get(key));
      //      } else if (mapA.containsKey(key) && mapB.containsKey(key) && Objects.equals(valueA, valueB)) {
      //          diffMap.put("key", key);
      //          diffMap.put("status", "unchanged");
      //          diffMap.put("oldValue", valueA);
      //      } else if (mapA.containsKey(key) && mapB.containsKey(key) && !Objects.equals(valueA, valueB)) {
      //          diffMap.put("key", key);
      //          diffMap.put("status", "changed");
      //          diffMap.put("oldValue", valueA);
      //          diffMap.put("newValue", valueB);

        Set<String> keySet = new TreeSet<>(firstMap.keySet());
        keySet.addAll(secondMap.keySet());

        for (String key : keySet) {
            if (!firstMap.containsKey(key)) {
                result.put(key, new KeyStatus("added", null, secondMap.get(key)));
            } else if (!secondMap.containsKey(key)) {
                result.put(key, new KeyStatus("deleted", firstMap.get(key)));
            } else if (Objects.equals(firstMap.get(key), secondMap.get(key))) {
                result.put(key, new KeyStatus("unchanged", firstMap.get(key)));
            } else if (!Objects.equals(firstMap.get(key), secondMap.get(key))) {
                result.put(key, new KeyStatus("changed", firstMap.get(key), secondMap.get(key)));
            }
           // list.add(diffMap);
        }
        return result;
    }
}
