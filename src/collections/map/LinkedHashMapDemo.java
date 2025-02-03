package collections.map;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapDemo {
    public static void main(String[] args) {
        Map<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("one", "1");
        linkedHashMap.put("two", "2");
        linkedHashMap.put("three", "3");
        linkedHashMap.put("four", "4");
        linkedHashMap.put("five", "5");
        linkedHashMap.get("one");
        System.out.println(linkedHashMap);
    }
}
