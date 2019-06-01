package streams;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Stream;

public class CreateStreamExample {
    public static void main(String[] args) {
        /**
         * Создание потока из массива
         * */
        Stream<String> streams = Stream.of("aaaa", "bbbb", "cccc","ddd","zz");

        /**
         * бесконечный поток констант
         * */
        Stream<String> streamsConst =  Stream.generate(() -> "Echo");
        streamsConst.forEach(str -> System.out.println(str));

        /**
         * бесконечный поток Random чисел с плавающей точкой
         * */
        Stream<Double> streamsRandom =  Stream.generate(Math::random);
        streamsRandom.forEach(dbl -> System.out.println(dbl));

        /**
         * бесконечный поток Int 0,1,2......n
         *
         * В 9 версии появился предикат PREDICATE
         * */
        Stream<BigInteger> streamsInteger =
                Stream.iterate(BigInteger.ZERO, n -> n.add(BigInteger.ONE));
        streamsInteger.forEach(elem -> System.out.println(elem));
    }
}
