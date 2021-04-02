package best_practise;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {

        int arr[] = new int[]{-3, 1, 5, 2, 0, -6, -5};

        for (int i = 0; i < arr.length; i++) {
            int minIndex = index(i, arr);
            int minValue = arr[minIndex];
            int tmp = arr[i];
            arr[i] = minValue;
            arr[minIndex] = tmp;
        }
        System.out.println(Arrays.toString(arr));
    }

    static int index(int offset, int[] arr) {
        int minIndex = offset;
        for (int i = offset; i < arr.length; i++) {
            if (arr[minIndex] > arr[i]) minIndex = i;
        }
        return minIndex;
    }
}
