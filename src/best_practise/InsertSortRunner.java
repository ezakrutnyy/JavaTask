package best_practise;

import java.util.Arrays;

public class InsertSortRunner {

    public static void main(String[] args) {
        int[] input = new int[]{-3, 1, 5, 2, 0, -6, -5};
        System.out.println(Arrays.toString(input));
        insertion(input);
        System.out.println(Arrays.toString(input));
    }

    public static void insertion(int[] input) {

        for (int i = 1; i < input.length; i++) {

            int current = input[i];

            int j = i;

            while (j > 0 && input[j-1] > current) {
                input[j] = input[j-1];
                j--;
            }
            input[j] = current;
        }
    }
}
