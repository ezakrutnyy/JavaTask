package collections.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MyHashMapDemo {

    public static void main(String[] args) {
        Map<Elem,String> map = new HashMap<>();
        map.put(new Elem("aaaa"), "aaa");
        map.put(new Elem("bbb"), "aaabbb");
        map.put(new Elem("cccc"), "ssdsdsd");
        map.put(new Elem("aaaa"), "fff");
        System.out.println(map);
    }
}


class Elem {
    private String str;

    public Elem(String str) {
        this.str = str;
    }

    @Override
    public boolean equals(Object o) {
        return this == o;
    }

    @Override
    public int hashCode() {
        return Objects.hash(str);
    }
}