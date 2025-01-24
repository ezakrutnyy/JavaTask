import java.util.Arrays;
import java.util.stream.IntStream;

public class Test {
    public static void main(String[] args) {
        IntStream.range(10, 20).forEach(System.out::println);
        Arrays.stream(new String[]{"aa", "bbbb", "cccccc", "dddd", "ddddddddddd", "sss", "dsss"})
                .filter(el -> el.length() > 5)
                .forEach(System.out::println);
    }
}