package collections.map;

import java.util.LinkedHashMap;

public class LinkedHashMapDemo {
    public static void main(String[] args) {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("one", "two");
        linkedHashMap.put("one", "five");
        System.out.println(linkedHashMap);
    }
}
