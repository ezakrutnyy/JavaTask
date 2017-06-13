package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Евгений on 14.06.2017.
 * Как преобразовать массив в ArrayList на Java?
 */
public class ArrayToArrayList {
    public static void main(String[] args) {
        String[] arr = {"Orange","Banana","Apple","Watermelon"};
        // 1 способ
        List<String> list1 = new ArrayList<String>(Arrays.asList(arr));
        System.out.println(list1);
        // 2 способ
        List<String> list2 = new ArrayList<String>();
        Collections.addAll(list2,arr);
        System.out.println(list2);

    }
}
