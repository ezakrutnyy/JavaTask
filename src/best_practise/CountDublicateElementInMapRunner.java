package best_practise;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.function.Function.identity;

public class CountDublicateElementInMapRunner {
    public static void main(String[] args) {

        Integer[] inputs = new Integer[]{3, 22, 3, 11, 22, 44, 77, 44, 33, 22, 11};

        final Map<Integer, Integer> res1 = Lists.newArrayList(inputs)
                .stream().collect(Collectors.toMap(identity(), value -> 1, Integer::sum));

        final Map<Integer, Integer> res2 = Lists.newArrayList(inputs)
                .stream().collect(Collectors.groupingBy(identity(), Collectors.summingInt(value -> 1)));

        final Map<Integer, Long> res3 = Arrays.stream(inputs)
                .collect(Collectors.groupingBy(identity(), Collectors.counting()));


        final Map<Integer, Integer> res4 = Maps.newHashMap();
        for (int elem : inputs) {
            res4.computeIfPresent(elem, (k, v) -> v + 1);
            res4.putIfAbsent(elem, 1);
        }

        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
        System.out.println(res4);
    }

}
