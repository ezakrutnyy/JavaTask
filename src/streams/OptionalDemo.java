package streams;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Optional;

public class OptionalDemo {
    public static void main(String[] args) {
        /**
         * [1] ofNullable() Дает возможность вернуть методу  getStr = null ссылку
         * */
        Optional<String> stropt = getStr();

        /**
         * [2] orElse() Возвращает значение по умолчанию для null указателя
         * */
        Optional<String> strForDefaultOpt = getStr();
        String strForDefault = strForDefaultOpt.orElse("default");
        System.out.println("orElse() - " + strForDefault);

        /**
         * [3] orElseGet() Возвращает значение по умолчанию для null указателя,
         * с применением лямбда функции
         * */
        List<String> listOpt = getListOpt().orElseGet(() -> Lists.newArrayList());
        System.out.println("orElseGet() - " + listOpt);

        /**
         * orElseThrow() Возвращает значение по умолчанию для null указателя,
         * с выбрасыванием исключения!
         * */
        try {
            String strException = getStr().orElseThrow(RuntimeException::new);
        } catch (Exception ex) {
            System.out.println("orElseThrow() - " + ex);
        }

        /**
         * [4] Альтернатива or() применяется, если orElseGet не подходит,
         * тк может отработать с падением
         * 9 JAVA
         * */

        /**
         * [5] Различнеы применения ifPresent
         * */
        List<String> collect = Lists.newArrayList("aaa");
        Optional<String> optL = Optional.of("bbb");
        optL.ifPresent(value -> collect.add(value));
        System.out.println("ifPresent() - " + collect);

        /**
         * [6] ifPresentOrElse еслп нет знаечния в if, применяем метод для else
         * 9 JAVA
         * */

        /**
         * [7] map(), результат операции как ifPresent, но не теряет возвращаемый результат
         * */
        List<String> res = Lists.newArrayList("aaa");
        Optional<Boolean> isRes = optL.map(v -> res.add(v));
        System.out.println("map() - " + isRes);


        /**
         * [8] flatMap() нужен для извлечения из одного Optional, другого, вложенного в него
         * */
        Optional<Double> optFlatMap = Optional.of(16.0)
                .flatMap(OptionalDemo::inverse).flatMap(OptionalDemo::sqrt);
        System.out.println(optFlatMap.orElse(666.00));

    }

    public static Optional<String> getStr() {
        return Optional.ofNullable(null);
    }

    public static Optional<List<String>> getListOpt() {

        return Optional.ofNullable(null);
    }

    public static Optional<Double> inverse(Double x) {
        return x == 0 ? Optional.empty() : Optional.of(1 / x);
    }

    public static Optional<Double> sqrt(Double x) {
        return x < 0 ? Optional.empty() : Optional.of(Math.sqrt(x));
    }


}
