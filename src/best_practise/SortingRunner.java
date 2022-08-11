package best_practise;

import java.util.Arrays;

public class SortingRunner {
    public static void main(String[] args) {
        final int[] mas = new int[]{-3, 1, 0, 5, 2, 0, -6, 33, -5};
        //System.out.println(Arrays.toString(new Sort(mas).bubbleSort()));
        //System.out.println(Arrays.toString(new Sort(mas).selectionSort()));
        System.out.println(Arrays.toString(new Sort(mas).insertSort()));
    }
}


class Sort {

    final private int[] arr;

    Sort(int[] arr) {
        this.arr = arr;
    }

    // O(n^2)
    int[] bubbleSort() {
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(j, j + 1);
                }
            }
        }

        return arr;
    }

    // O(n^2)
    int[] selectionSort() {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = minIndex(i);
            swap(i, minIndex);
        }
        return arr;
    }

    private int minIndex(int offset) {
        int minIndex = offset;
        for (int i = offset; i < arr.length; i++) {
            if (arr[minIndex] > arr[i]) minIndex = i;
        }
        return minIndex;
    }

    int[] insertSort() {
        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] > current) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = current;

        }
        return arr;
    }

    private void swap(int indexFrom, int indexTo) {
        int tmp = arr[indexFrom];
        arr[indexFrom] = arr[indexTo];
        arr[indexTo] = tmp;
    }

}