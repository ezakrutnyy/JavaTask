package collections.map;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class HashMapDemo {
    public static void main(String[] args) {
        /*
        * getOrDefault()
        * */
        System.out.println("*******************getOrDefault()*****************************");
        HashMap<String, Integer> map = Maps.newHashMap();
        map.put("bob", 12);
        Integer val = map.getOrDefault("alice", 3);
        System.out.println(val);

        /* merge() */
        System.out.println("*******************merge()*****************************");
        map.put("alice", 7);
        int cnt = map.merge("alice", 1, Integer::sum);
        System.out.println(cnt);

        System.out.println("*******************putIfAbsent()*****************************");
        map.putIfAbsent("bob", 6);
        System.out.println(map);

        System.out.println("*******************compute()*****************************");
        map.compute("baron", (key, value) -> 100);
        System.out.println(map);

        System.out.println("*******************computeIfAbsent()*****************************");
        Integer rishid = map.computeIfAbsent("roshild", key -> 200);
        System.out.println(rishid);
        System.out.println(map);

        System.out.println("*******************computeIfPresent()*****************************");
        Integer roshild2 = map.computeIfPresent("roshild", (key, value) -> value+500);
        System.out.println(roshild2);
        System.out.println(map);

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


        Map<String, List<String>> maps = Maps.newHashMap();
        maps.put("810", Lists.newArrayList("1000.00"));

        maps.computeIfAbsent("840", k -> Lists.newArrayList()).add("5500");
        System.out.println(maps);

    }
}
