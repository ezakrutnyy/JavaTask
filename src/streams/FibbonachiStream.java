package streams;

import java.util.function.Supplier;
import java.util.stream.Stream;

public class FibbonachiStream {

    public static void main(String[] args) {

        Stream.generate(supplierFibbonachi).filter(n -> n % 2 == 0).limit(40)
                .forEach(System.out::println);
    }


    private static Supplier<Integer> supplierFibbonachi = new Supplier<Integer>() {

        private Integer first = 0;

        private Integer second = 1;

        @Override
        public Integer get() {
            Integer s = first + second;
            first = second;
            second = s;
            return s;
        }
    };
}
