package best_practise;

import com.google.common.collect.Sets;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Set;

public class SumPairRunner {
    /*
     * в массиве найти любую пару чисел, которые дают в сумме заданный num, за линейное время
     *  4, 12, 5, 9, 7, 2, 21
     * */
    public static void main(String[] args) {
        Integer[] array = new Integer[]{4, 12, 5, 9, 7, 2, 21};
        int num = 12;
        Pair<Integer, Integer> pair = getPairSum(array, num);
        if (pair == null) return;

        System.out.println(pair.getLeft() + " + " + pair.getRight() + " = " + num);
    }

    private static Pair<Integer, Integer> getPairSum(Integer[] array, int search) {
        final Set<Integer> ints = Sets.newHashSet(array);
        for (Integer anInt : ints) {
            int diff = search - anInt;
            if (ints.contains(diff)) return Pair.of(anInt, diff);
        }

        return null;

    }
}
