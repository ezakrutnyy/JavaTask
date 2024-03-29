package guava;

import com.google.common.base.Preconditions;

/**
 * Created by Евгений on 14.11.2018.
 */
public class PredictionsDemo {
    public static void main(String[] args) {
        try {
            System.out.println(sqrt(49));
            System.out.println(sum(3, 3));
            System.out.println(getValue(66));
        } catch (NullPointerException | IllegalArgumentException | IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }

    private static int sum(Integer a, Integer b) {
        Preconditions.checkNotNull(a, "Illegal Argument passed: First parameter is Null.");
        Preconditions.checkNotNull(b, "Illegal Argument passed: Second parameter is Null.");
        return a + b;
    }

    private static int sqrt(Integer a) {
        Preconditions.checkArgument(a > 0, "Illegal Argument passed: Negative value %s.", a);
        return (int) Math.sqrt(a);
    }

    public static int getValue(int input) {
        int[] data = {1, 2, 3, 4, 5};
        Preconditions.checkElementIndex(input, data.length, "Illegal Argument passed: Invalid index.");
        return data[input];
    }
}
