package best_practise;

import java.util.Arrays;

public class BubleSort {
    public static void main(String[] args) {
        int[] mas = new int[]{-3, 1, 5, 2, 0, -6, -5};
        System.out.println(Arrays.toString(mas));
    }

    public static void bubleSort(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
    }
}