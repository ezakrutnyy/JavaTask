package streams;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Stream;

import static abstractAndInterfaces.functional.SupplierDemo.generateConstStr;
import static abstractAndInterfaces.functional.SupplierDemo.generateRandomInteger;

public class CreateStreamExample {
    public static void main(String[] args) {

        /**
         * бесконечный поток констант
         * */
        Stream<String> streamsConst =  Stream.generate(generateConstStr);
        streamsConst.forEach(str -> System.out.println(str));

        /**
         * бесконечный поток Random чисел с плавающей точкой
         * */
        Stream<Integer> streamsRandom =  Stream.generate(generateRandomInteger);
        streamsRandom.forEach(dbl -> System.out.println(dbl));

        /**
         * бесконечный поток Int 0,1,2......n
         *
         * В 9 версии появился предикат PREDICATE
         * */
        Stream<BigInteger> streamsInteger =
                Stream.iterate(BigInteger.ZERO, n -> n.add(BigInteger.ONE));
        streamsInteger.forEach(System.out::println);
    }
}
