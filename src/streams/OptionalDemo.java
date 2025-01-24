package streams;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Optional;

public class OptionalDemo {
    public static void main(String[] args) {
        /**
         * [1] ofNullable() Дает возможность вернуть методу  getStr = null ссылку
         * */
        System.out.println("-----ofNullable()--------");
        String s = null;
        String k = Optional.ofNullable(s).orElse("3");
        System.out.println("ofNullable value is " + k);

        Optional<String> stropt = getStr();

        /**
         * [2] orElse() Возвращает значение по умолчанию для null указателя
         * */
        System.out.println("---------------orElse()------------");
        Optional<String> strForDefaultOpt = getStr();
        String strForDefault = strForDefaultOpt.orElse("default");
        System.out.println("orElse() - " + strForDefault);

        /**
         * [3] orElseGet() Возвращает значение по умолчанию для null указателя,
         * с применением лямбда функции
         * */
        System.out.println("---------------orElseGet()------------");
        List<String> listOpt = getListOpt().orElseGet(Lists::newArrayList);
        System.out.println("orElseGet() - " + listOpt);

        /**
         * [4] orElseThrow() Возвращает значение по умолчанию для null указателя,
         * с выбрасыванием исключения!
         * */
        System.out.println("---------------orElseThrow()------------");
        try {
            String strException = getStr().orElseThrow(RuntimeException::new);
        } catch (Exception ex) {
            System.out.println("orElseThrow() - " + ex);
        }

        /**
         * [5] Различые применения ifPresent
         * */
        System.out.println("---------------ifPresent()------------");
        List<String> collect = Lists.newArrayList("aaa");
        Optional<String> optL = Optional.of("bbb");
        optL.ifPresent(collect::add);
        System.out.println("ifPresent() - " + collect);

        /**
         * [6] map(), результат операции как ifPresent, но не теряет возвращаемый результат
         * */
        System.out.println("---------------map()------------");
        Optional<String> isRes = optL.map(str -> str + " and map()");
        System.out.println("map() - " + isRes);

        /**
         * [7] flatMap() нужен для извлечения из одного Optional, другого, вложенного в него
         * */
        System.out.println("---------------flatMap()------------");
        Optional<Double> optFlatMap = Optional.of(16.0)
                .flatMap(OptionalDemo::inverse).flatMap(OptionalDemo::sqrt);
        System.out.println(optFlatMap.orElse(666.00));
    }

    private static Optional<String> getStr() {
        return Optional.empty();
    }

    private static Optional<List<String>> getListOpt() {

        return Optional.empty();
    }

    private static Optional<Double> inverse(Double x) {
        return x == 0 ? Optional.empty() : Optional.of(1 / x);
    }

    private static Optional<Double> sqrt(Double x) {
        return x < 0 ? Optional.empty() : Optional.of(Math.sqrt(x));
    }


}
