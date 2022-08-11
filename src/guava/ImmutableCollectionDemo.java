package guava;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;

import java.util.List;
import java.util.Set;

/**
 * Created by Евгений on 15.11.2018.
 */
public class ImmutableCollectionDemo {
    public static void main(String[] args) {

        Short s = 3;

        Set<String> immutableSets = ImmutableSet.of(
                "aaa",
                "bbb",
                "ccc",
                "aaa"
        );
        System.out.println(immutableSets);

        List<String> immutableLists = ImmutableList.of(
                "aaa",
                "bbb",
                "ccc",
                "aaa"
        );
        System.out.println(immutableLists);

        ImmutableMap<String, String> immutableMap = ImmutableMap.of(
                "aaa", "bbb",
                "ccc", "ddd"
        );

        System.out.println(immutableMap);


    }
}
