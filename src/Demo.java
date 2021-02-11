import java.util.Arrays;

public class Demo {

    public static void main(String[] args) {
        System.out.println(Arrays.stream(new int[]{1,2,3,4,5}).reduce(1, (left, right) -> left * right));
    }
}
