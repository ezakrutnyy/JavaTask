package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Евгений on 14.06.2017.
 * Как конвертировать ArrayList в массив на Java?
 */
public class ArrayListToArray {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Orange");
        list.add("Apple");
        list.add("Banana");
        String[] arrStr = list.toArray(new String[0]);
        System.out.println(Arrays.toString(arrStr));
    }
}


