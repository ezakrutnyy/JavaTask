package array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Евгений on 23.07.2017.
 */
public class ArrayMainMethodsClass {
    public static void main(String[] args) {
        char[] copyFrom = {'d', 'e', 'c', 'a', 'f', 'f', 'e', 'i', 'n', 'a', 't', 'e', 'd' };
        char[] copyTo = new char[7];
        char[] copyTo2 = new char[7];

        copyTo = Arrays.copyOfRange(copyFrom,2,9);
        copyTo2 = Arrays.copyOf(copyFrom,7);
        System.out.println(copyFrom);
        System.out.println(copyTo);
        System.out.println(copyTo2);

        Arrays.sort(copyFrom);
        System.out.println(copyFrom);

        String[] fruit = {"Orange", "Banana", "Apple"};
        System.out.println(Arrays.toString(fruit));


        Arrays.sort(fruit, Comparator.reverseOrder());
        System.out.println(Arrays.toString(fruit));

    }
}
