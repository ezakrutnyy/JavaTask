package generics;

import com.google.common.collect.Lists;

import java.util.Collection;

/* Переменная типа */
public class TypeVariable {

    public static void main(String[] args) {
        System.out.println(max(Lists.newArrayList(5, 3, 2, 1, 3, 2, 0)));
        System.out.println(min(Lists.newArrayList(5, 3, 2, 1, 3, 2, 0)));
    }

    /* Recursive bound */
    public static <T extends Comparable<T>> T max(Collection<? extends T> collections) {
        T candidate = collections.iterator().next();
        for (T elem : collections) {
            if (candidate.compareTo(elem) < 0) candidate = elem;
        }
        return candidate;
    }

    /* Recursive bound */
    public static <T extends Object & Comparable<? super T>> T min(Collection<? extends T> collections) {
        T candidate = collections.iterator().next();
        for (T elem : collections) {
            if (candidate.compareTo(elem) > 0) candidate = elem;
        }
        return candidate;
    }
}