package example;

import java.util.Arrays;

public class ArrayExample {
    public static void main(String[] args) {
        int[] a = {5,5};
        int b = 0;
        a[b] = b = --b;
        System.out.println(Arrays.toString(a));
    }
}
