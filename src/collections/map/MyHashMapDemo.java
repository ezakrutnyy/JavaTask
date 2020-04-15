package collections.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MyHashMapDemo {

    public static void main(String[] args) {
        System.out.println(110183 & 15);
        Map<Elem,String> map = new HashMap<>();
        map.put(new Elem("aaaa"), "aaa");
        map.put(new Elem("bbb"), "aaabbb");
        map.put(new Elem("cccc"), "ssdsdsd");
    }
}


class Elem {
    private String str;

    public Elem(String str) {
        this.str = str;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Elem elem = (Elem) o;
        return Objects.equals(str, elem.str);
    }

    @Override
    public int hashCode() {
        return 1;
    }
}