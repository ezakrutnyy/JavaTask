package collections;

import com.google.common.collect.Maps;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapDemo {
    public static void main(String[] args) {
        /*
        * getOrDefault()
        * */
        System.out.println("*******************getOrDefault()*****************************");
        HashMap<String, Integer> map = Maps.newHashMap();
        map.put("bob", 12);
        Integer val = map.getOrDefault("alice", 0);
        System.out.println(val);

        /* merge() */
        System.out.println("*******************merge()*****************************");
        map.put("alice", 7);
        int cnt = map.merge("alice", 1, Integer::sum);
        System.out.println(cnt);

        /* обход отображения  for() */
        System.out.println("*******************for()*****************************");
        map.forEach((k,v) -> System.out.println(String.format("key = %s, value = %d", k, v)));

        /* обход через iterable() */
        System.out.println("*******************iterable()*****************************");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(String.format("key = %s, value = %d", entry.getKey(), entry.getValue()));
        }

        /* обход через итератор */
        System.out.println("*******************iterator()*****************************");
        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String,Integer> entryIterator = iterator.next();
            System.out.println(String.format("key = %s, value = %d", entryIterator.getKey(), entryIterator.getValue()));

        }

    }
}
