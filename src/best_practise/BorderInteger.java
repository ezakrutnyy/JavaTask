package best_practise;

import java.util.Arrays;

public class BorderInteger {

    // [1,4,5,2,3,9,8,11,0] => "0-5,8-9,11"
    //[1,4,3,2] => "1-4"
    //[1,4] => "1,4"

    public static void main(String[] args) {

        Integer[] array = new Integer[]{1, 4, 5, 2, 3, 9, 8, 11, 0};
        Arrays.sort(array);

        Border border = new Border();

        Integer left = array[0];

        Integer right = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] - array[i - 1] > 1) {
                border.append(left, right);
                left = array[i];
            } else {
                right = array[i];
            }
        }

        border.append(left, right);

        System.out.println(border.getResult());
    }
}

class Border {

    final private StringBuilder builder;

    Border() {
        this.builder = new StringBuilder();
    }

    public void append(Integer left, Integer right) {

        if (right == null || left >= right) {
            builder.append(left).append("\n");
        } else {
            builder.append(left).append(" - ").append(right).append("\n");
        }
    }

    String getResult() {
        return builder.toString();
    }
}
