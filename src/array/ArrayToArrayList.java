package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Евгений on 14.06.2017.
 * Как преобразовать массив в ArrayList на Java?
 */
public class ArrayToArrayList {
    public static void main(String[] args) {
        String[] arr = {"Orange", "Banana", "Apple", "Watermelon"};
        // 1 способ
        List<String> list1 = new ArrayList<>(Arrays.asList(arr));
        System.out.println(list1);

        // 2 способ
        List<String> fruits = Arrays.stream(arr).collect(Collectors.toList());
        System.out.println(fruits);

        // 3 способ
        List<String> list2 = new ArrayList<>();
        Collections.addAll(list2, arr);
        System.out.println(list2);
    }
}