package streams;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExample {

    public static void main(String[] args) {
        List<String> lists = Lists.newArrayList("молоко","киш", "крот", "лес","воротник","шило", "мыло", "частота");

        /**
         * [EXAMPLE 1]
         * посчитать количество слов, чья длина больше 6 букв
         * */
        long length = lists.parallelStream().filter(word -> word.length()> 6).count();
        System.out.println("length: "+length);

        /**
         * [EXAMPLE 2]
         *  - переведем все буквы в верхний регистр  = 3 буквам
         *  - limit - берет первые два элемента потока
         *  - вывести на экран
         * */
        lists.stream().filter(predicateFilter1)
                .map(String::toUpperCase)
                .limit(2)
                .forEach(printConsumer);

        /**
         * [EXAMPLE 3]
         *  - skip - отбрасывает первые два элемента потока
         * */
        lists.stream().skip(2).map(funcTreeWord).forEach(printConsumer);

        /**
         * [EXAMPLE 4]
         * flatMap() склеивает  массивы масссивов в одну строку
         * */
        List<List<String>> deepLists = Lists.newArrayList(
                Lists.newArrayList("zak","mak"),
                Lists.newArrayList("rak","dac"),
                Lists.newArrayList("mirror","bolk")
        );

        String strDep = deepLists.stream().flatMap(str -> str.stream()).collect(Collectors.joining());
        List<String> listDep = deepLists.stream().flatMap(list -> list.stream()).collect(Collectors.toList());
        System.out.println(strDep);
        System.out.println(listDep);

        /**
         * [EXAMPLE 5]
         * - toArray(String[]::new)
         * - Возврат результата в виде []
         * */
        List<String> list = ImmutableList.of("aaa","","", "ddddd");
        String[] mas = list.stream().filter(StringUtils::isNoneBlank).toArray(String[]::new);
        System.out.println("One step: "+Arrays.toString(mas));

        /**
         * [EXAMPLE 6]
         * - collect(Collectors.toList())
         * */
        List<Integer> listFrom = Lists.newArrayList(3, 6, 11, 2, 6,-10, 5, 8, 22, 45, 10, 1);
        List<Integer> listTo = listFrom.stream().sorted(comp).filter(n -> n > 6).collect(Collectors.toList());
        System.out.println(listTo);

        /**
         * [EXAMPLE 7]
         * - collect(Collectors.toSet())
         * */
        Set<Integer> setTo = listFrom.stream().collect(Collectors.toSet());
        System.out.println(setTo);

        /**
         * [EXAMPLE 8]
         * - collect() конкретная разновидность коллекции, например дерево
         * */
        Set<Integer> treeSetTo = listFrom.stream().collect(Collectors.toCollection(TreeSet::new));
        System.out.println(treeSetTo);

        /**
         * [EXAMPLE 9]
         * - collect() joining в строку
         * */
        String resJoin = listFrom.stream().map(String::valueOf).collect(Collectors.joining());
        System.out.println(resJoin);

        /**
         * [EXAMPLE 10]
         * - collect() joining  с разбивкой
         * */
        String resJoinWithSeparator = listFrom.stream().map(Object::toString).collect(Collectors.joining(","));
        System.out.println(resJoinWithSeparator);

        /**
         * [EXAMPLE 11]
         * если результат нужно свести к результатирующей функции max,min, average, amount
         * Collectors.summarizingInt
         * Collectors.summarizingDouble
         * Collectors.summingDouble - отдельный метод для сохранения сумм
         * */
        List<Double> lst = Lists.newArrayList(-10.00,20.00,-2.00,100.00,30.00,50.00);
        DoubleSummaryStatistics amounts = lst.stream().filter(amount -> amount > 0).collect(Collectors.summarizingDouble(Double::new));
        System.out.println("Sum: "+amounts.getSum());
        System.out.println("Average: "+amounts.getAverage());
        System.out.println("Min: "+amounts.getMin());
        System.out.println("Max: "+amounts.getMax());
        System.out.println("Count: "+amounts.getCount());

        Double amounts2 = lst.stream().filter(amount -> amount > 0).collect(Collectors.summingDouble(Double::valueOf));
        System.out.println(amounts2);

        /**
         * [EXAMPLE 12]
         * Накопление в отображении
         * Collectors.toMap();
         * */
        List<Employee> employees = Lists.newArrayList(
                new Employee("Alex", "Moscow", 22),
                new Employee("Max", "Kursk", 55),
                new Employee("Tom", "Moscow", 10),
                new Employee("Carl", "Moscow", 44),
                new Employee("Sam", "Voronezh", 26),
                new Employee("Fox", "Yaroslavl",27),
                new Employee("Ronald", "Moscow",19),
                new Employee("Mike", "Yaroslavl",23)
        );


        Map<String, Set<Employee>> maps = employees.stream()
                .collect(Collectors.toMap(
                        Employee::getCity,
                        Collections::singleton,
                        (emp1, emp2) -> {
                            Set<Employee> union = Sets.newHashSet(emp1);
                            union.addAll(emp2);
                            return  union;
                        }));

        System.out.println("toMap: "+maps);

        /**
         * [EXAMPLE 13]
         * - Группирование и разделение
         * - Collectors.groupingBy();
         * */
        Map<String, List<Employee>> mapsByGrouping = employees.stream().collect(Collectors.groupingBy(Employee::getCity));
        System.out.println("groupingBy: "+mapsByGrouping);

        /**
         * [EXAMPLE 14]
         * Группирование и разделение
         * Predicate выражение разделяыет на 2 листа, для true -> возвращает лист подходящий под условие
         *  и  false лист содержащий остальные значения
         * Collectors.partitioningBy();
         * */
        Map<Boolean, List<Employee>> mapsByPartitioning =
                employees.stream().collect(Collectors.partitioningBy(emp -> emp.getCity().equals("Moscow")));
        System.out.println("partitioningBy: "+mapsByPartitioning.get(false));

        /**
         * [EXAMPLE 15]
         * Нисходящие коллекторы
         * Дополнительная обработка сгрупированных списков
         * toSet()
         * */
        Map<String, Set<Employee>> mapToSet = employees.stream().collect(Collectors.groupingBy(Employee::getCity, Collectors.toSet()));
        System.out.println("MapToSet: "+mapToSet);

        /**
         * [EXAMPLE 16]
         * - counting()
         * */
        Map<String, Long> mapCounting = employees.stream().collect(Collectors.groupingBy(Employee::getCity, Collectors.counting()));
        System.out.println("MapCounting: "+mapCounting);

        /**
         * [EXAMPLE 17]
         * - summing()
         * */
        Map<String, Integer> mapSumming = employees.stream().collect(Collectors.groupingBy(Employee::getCity, Collectors.summingInt(Employee::getOld)));
        System.out.println("mapSumming: "+mapSumming);

        /**
         * [EXAMPLE 18]
         * - maxBy()
         * */
        Map<String, Optional<Employee>> mapMaxOld = employees.stream()
                .collect(Collectors.groupingBy(Employee::getCity,
                        Collectors.maxBy(Comparator.comparing(Employee::getOld))));
        System.out.println("mapMaxOld: "+mapMaxOld);

        /**
         * [EXAMPLE 19]
         * - mapping()
         * - получить какие то новые данные из Employee
         * */
        Map<String, Optional<String>> mapMapping = employees.stream()
                .collect(Collectors.groupingBy(Employee::getCity,
                        Collectors.mapping(Employee::getName, Collectors.maxBy(Comparator.comparing(String::length)))));
        System.out.println("mapMinOld: "+mapMapping);

        /**
         * [EXAMPLE 20]
         * - mapping min By old
         * */
        Map<String, Optional<Integer>> mapMinOld = employees.stream()
                .collect(Collectors.groupingBy(Employee::getCity,
                        Collectors.mapping(Employee::getOld, Collectors.minBy(Comparator.comparing(Integer::valueOf)))));

        /**
         * [EXAMPLE 21]
         * - grouping and summarizing = summaryStatics
         * */
        Map<String, IntSummaryStatistics> summaryStatics = employees.stream()
                .collect(Collectors.groupingBy(Employee::getCity, Collectors.summarizingInt(Employee::getOld)));
        System.out.println("summaryStatics: "+summaryStatics);

        /**
         * [EXAMPLE 22]
         * grouping and filtering list
         * 9 JAVA
         * */
//        Map<String, Set<Employee>> mapWithFilters = employees.stream()
//                .collect(Collectors.groupingBy(Employee::getCity, Collectors.filtering(empl -> empl.getOld() > 30, toSet)));
//        System.out.println("mapWithFilters: "+mapWithFilters);

        /**
         * [EXAMPLE 23]
         * подсчет суммы n-го количества, умножения, деления, остатка...
         * так же можно применить любые операции к двоичной функции
         * reduce()
         * */
        List<Integer> listInts = Lists.newArrayList(3,1,-4,2,9);
        Optional<Integer> reduceSumm = listInts.stream()
                .reduce((o1,o2) -> o1+o2);
        System.out.println("reduceSumm: "+reduceSumm.orElse(0));

        /**
         * [EXAMPLE 24]
         * reduce() сразу  получаем Integer
         */
        Integer reduceSummInteger = listInts.stream()
                .reduce(0, (o1,o2) -> o1+o2);
        System.out.println("reduceSummInteger: "+reduceSumm);

        /**
         * [EXAMPLE 25]
         * reduce() с результатом накопления
         */
        int totalcount = listInts.stream().reduce(0, (cnt, o1) -> cnt += o1);
        System.out.println("totalcount: "+totalcount);

        /**
         *  [EXAMPLE 26]
         * Потоки примитивных данных IntStream, LongStream, DoubleStream
         * */
//        Supplier<Stream<Integer>> streamSupplierInt
//                = () -> Stream.of(3, 2, 1, 10);
        System.out.println("intStream: sum: "+listInts.stream().mapToInt(Integer::intValue).sum());
        System.out.println("intStream: average: "+listInts.stream().mapToInt(Integer::intValue).average());

        /**
         * [EXAMPLE 27]
         * многоразовый вызов терминальных функция для stream
         * */
        Supplier<Stream<String>> streamSupplierStr
                = () -> Stream.of("A", "B", "C", "D");
        Optional<String> result1 = streamSupplierStr.get().findAny();
        System.out.println(result1.get());
        Optional<String> result2 = streamSupplierStr.get().findFirst();
        System.out.println(result2.get());

    }

    public static Predicate<String> predicateFilter1 = s -> s.length() == 4;

    public static Predicate<String> predicateFilter2 = new Predicate<String>() {
        @Override
        public boolean test(String s) {
            return s.length() == 3;
        }
    };


    public static Consumer<String> printConsumer = new Consumer<String>() {
        public void accept(String name) {
            System.out.println(name);
        }
    };

    public static Function<String, String> funcTreeWord = new Function<String, String>() {
        @Override
        public String apply(String s) {
            return s.substring(0,3);
        }
    };

    public static Comparator<Integer> comp = new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2.compareTo(o1);
        }
    };

}
