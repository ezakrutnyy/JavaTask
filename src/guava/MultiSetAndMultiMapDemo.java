package guava;

import com.google.common.collect.*;

import java.util.List;
import java.util.Set;

/**
 * Created by Евгений on 14.11.2018.
 */
public class MultiSetAndMultiMapDemo {
    public static void main(String[] args) {
        Multiset<String> setsM = HashMultiset.create();
        setsM.add("aaa");
        setsM.add("bbb");
        setsM.add("vvv");
        setsM.add("aaa");
        setsM.add("bbb");
        setsM.add("ccc");
        System.out.println(setsM.count("bbb"));
        Set<String> sets = setsM.elementSet();
        System.out.println(sets);

        Multimap<String, String> mupltiMap = TreeMultimap.create();
        mupltiMap.put("aaa", "123");
        mupltiMap.put("bbb", "132");
        mupltiMap.put("ccc", "2323");
        mupltiMap.put("aaa", "2323");
        mupltiMap.put("aaa", "753");
        mupltiMap.put("aaa", "2323");
        List<String> lst = Lists.newArrayList(mupltiMap.values());
        System.out.println(lst);
        System.out.println(mupltiMap.get("aaa"));

        BiMap<Integer, String> biMap = HashBiMap.create();
        biMap.put(101, "aaa");
        biMap.put(102, "bbb");
        biMap.put(103, "ccc");
        System.out.println(biMap);
        System.out.println(biMap.inverse());
    }
}