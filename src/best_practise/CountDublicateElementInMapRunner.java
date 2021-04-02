package best_practise;

import com.google.common.collect.Lists;

import java.util.Map;
import java.util.stream.Collectors;

import static java.util.function.Function.identity;

public class CountDublicateElementInMapRunner {
    public static void main(String[] args) {

        Map<Integer, Integer> res1 = Lists.newArrayList(3, 22, 3, 11, 22, 44, 77, 44, 33, 22, 11)
                .stream().collect(Collectors.toMap(identity(), value -> 1, Integer::sum));

        Map<Integer, Integer> res2 = Lists.newArrayList(3, 22, 3, 11, 22, 44, 77, 44, 33, 22, 11)
                .stream().collect(Collectors.groupingBy(identity(), Collectors.summingInt(value -> 1)));

        System.out.println(res1);
        System.out.println(res2);
    }

}
