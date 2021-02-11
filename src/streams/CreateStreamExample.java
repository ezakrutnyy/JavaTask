package streams;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static abstractAndInterfaces.functional.SupplierDemo.generateRandomInteger;

public class CreateStreamExample {

    public static void main(String[] args) {

        /**
         * бесконечный поток Random чисел с плавающей точкой
         * */
        Stream<Integer> streamsRandom = Stream.generate(generateRandomInteger).limit(10);
        streamsRandom.forEach(System.out::println);

        /**
         * бесконечный поток Int 0,1,2......n
         *
         * В 9 версии появился предикат PREDICATE
         * */
        Stream<BigInteger> streamsInteger =
                Stream.iterate(BigInteger.ZERO, n -> n.add(BigInteger.ONE)).limit(10);
        streamsInteger.forEach(System.out::println);

        /**
         * Create streams, by builder
         * * */
        Stream.Builder<String> builder = Stream.builder();
        Stream<String> stream = builder.add("aaa").add("bbb").add("ccc").build();
        stream.forEach(System.out::println);

        /**
         * Create Ints streams
         * * */
        IntStream intStreams = IntStream.range(12, 24);
        intStreams.forEach(System.out::println);


        /**
         * Create streams, by array
         * * */
        Stream<Integer> streamArray = Arrays.stream(new Integer[]{1, 1, 2, 3, 5, 8, 13, 21, 34});
        streamArray.forEach(System.out::println);

    }
}
