package streams;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExample {

    public static void main(String[] args) {


        List<Employee> employees = Lists.newArrayList(
                new Employee("Alex", "Moscow", 22),
                new Employee("Max", "Kursk", 55),
                new Employee("Tom", "Moscow", 10),
                new Employee("Carl", "Moscow", 44),
                new Employee("Sam", "Voronezh", 26),
                new Employee("Fox", "Yaroslavl",27),
                new Employee("Ronald", "Moscow",19),
                new Employee("Mike", "Yaroslavl",23),
                new Employee("Alex", "Moscow", 22)
        );

        System.out.println("**************************************************************************");
        System.out.println(" Примеры использования filter, findFirst, findAny, skip, limit и count");
        System.out.println("**************************************************************************");


        long length = employees.parallelStream().filter(predicateFilter1).count();
        System.out.println("count()"+length);


        System.out.println("limit()");
        employees.stream()
                .filter(predicateFilter1)
                .map(Employee::getName)
                .limit(2)
                .forEach(printConsumer);

        System.out.println("skip()");
        employees.stream()
                .skip(2)
                .map(funcTreeWord)
                .forEach(printConsumer);


        System.out.println("findAny()");
        String nameAny = employees.stream().filter(predicateFilter1).findAny().map(Employee::getName).orElse("mister n");
        System.out.println(nameAny);

        System.out.println("findFirst()");
        String nameFirst = employees.stream().filter(predicateFilter1).findFirst().map(Employee::getName).orElse("mister n");
        System.out.println(nameFirst);

        System.out.println("**************************************************************************");
        System.out.println(" Примеры использования Match функций (anyMatch, allMatch, noneMatch)");
        System.out.println("**************************************************************************");

        boolean flag = false;

        System.out.println("anyMatch()");
        flag = employees.stream().anyMatch(predicateFilter1);
        System.out.println(flag);

        System.out.println("allMatch()");
        flag = employees.stream().allMatch(predicateFilter1);
        System.out.println(flag);

        System.out.println("noneMatch()");
        flag = employees.stream().noneMatch(predicateFilter1);
        System.out.println(flag);

        System.out.println("**************************************************************************");
        System.out.println(" Примеры использования Map функций (map, mapToInt, mapToDouble, mapToLong, " +
                "FlatMap, ,FlatMapToInt)");
        System.out.println("**************************************************************************");

        List<List<String>> deepLists = Lists.newArrayList(
                Lists.newArrayList("zak","mak"),
                Lists.newArrayList("rak","dac"),
                Lists.newArrayList("mirror","bolk")
        );

        System.out.println("flatMap()");
        String strDep = deepLists.stream().flatMap(str -> str.stream()).collect(Collectors.joining());
        List<String> listDep = deepLists.stream().flatMap(list -> list.stream()).collect(Collectors.toList());
        System.out.println(strDep);
        System.out.println(listDep);

        System.out.println("flatMap()");
        Collection<String> collection = Arrays.asList("1,2,0", "4,5");
        String[] number = collection.stream()
                .flatMap(p -> Arrays.asList(p.split(",")).stream())
                .toArray(String[]::new);

        System.out.println(Arrays.toString(number));

        System.out.println("flatMapToInt()");
        int sum = collection.stream()
                .flatMapToInt(p -> Arrays.asList(p.split(",")).stream()
                .mapToInt(Integer::parseInt)).sum();
        System.out.println(sum);

        System.out.println("map()");
        employees.stream().filter(predicateFilter1).map(Employee::getName).forEach(printConsumer);

        /*
        * Объект IntStream, после применения результатирующей функции, вохвращает примитив int
        * */
        System.out.println("intStream: sum: "+employees.stream().mapToInt(Employee::getOld).sum());
        System.out.println("intStream: average: "+employees.stream().mapToInt(Employee::getOld).average());
        System.out.println("intStream: max element: "+employees.stream().mapToInt(Employee::getOld).max());
        System.out.println("intStream: min element: "+employees.stream().mapToInt(Employee::getOld).min());
        System.out.println("mapToInt is int[] :"+Arrays.toString(employees.stream().mapToInt(Employee::getOld).toArray()));

        System.out.println("**************************************************************************");
        System.out.println(" Примеры использования distinct()");
        System.out.println("**************************************************************************");

        employees.stream().distinct().map(Employee::getName).forEach(printConsumer);

        System.out.println("**************************************************************************");
        System.out.println(" Примеры использования Sorted()");
        System.out.println("**************************************************************************");

        List<Employee> sortedEmployeeList = employees.stream()
                .sorted(new ComparatorEmployeeByOld())
                .collect(Collectors.toList());

        System.out.println("sortedEmployeeList by old: "+sortedEmployeeList);

        sortedEmployeeList = employees.stream()
                .sorted(Comparator.comparing(Employee::getCity))
                .collect(Collectors.toList());

        System.out.println("sortedEmployeeList by city: "+sortedEmployeeList);


        System.out.println("**************************************************************************");
        System.out.println(" Примеры использования Max и Min функций");
        System.out.println("**************************************************************************");

        Integer minOld = employees.stream()
                .map(Employee::getOld)
                .min(Integer::compareTo)
                .orElse(0);
        System.out.println("Min old: " +minOld);

        String maxCity = employees.stream()
                .map(Employee::getCity)
                .max(String::compareTo)
                .orElse("");
        System.out.println("Max City: " +maxCity);

        System.out.println("**************************************************************************");
        System.out.println(" Примеры использования ForEach и Peek функций");
        System.out.println("**************************************************************************");

        System.out.println("ForEach");
        employees.stream().forEach(emp -> emp.setOld(99));
        System.out.println(employees);

        System.out.println("Peak");
        employees = employees.stream().peek(emp -> emp.setOld(RandomUtils.nextInt(0, 100))).collect(Collectors.toList());
        System.out.println(employees);

        System.out.println("**************************************************************************");
        System.out.println("Примеры использования Reduce функции");
        System.out.println("**************************************************************************");


        Optional<Integer> reduceSumm = employees.stream()
                .map(Employee::getOld)
                .reduce((o1,o2) -> o1+o2);
        System.out.println("reduceSum old: "+reduceSumm.orElse(0));


        Integer reduceSummInteger = employees.stream()
                .map(Employee::getOld)
                .reduce(0, (o1,o2) -> o1+o2);
        System.out.println("reduceSum old or 0: "+reduceSummInteger);

        int totalcount = employees.stream()
                .map(Employee::getOld)
                .reduce(0, (cnt, o1) -> cnt += o1);
        System.out.println("totalcount: "+totalcount);


        System.out.println("**************************************************************************");
        System.out.println("Примеры использования toArray и collect функции");
        System.out.println("**************************************************************************");

        /*
         * Collectors.joining(",")
         */
        String resJoinWithSeparator = employees.stream()
                .map(Employee::getCity)
                .distinct()
                .collect(Collectors.joining(","));
        System.out.println("Collectors.joining: "+resJoinWithSeparator);

        /*
         * - toArray(String[]::new)
         * - Возврат результата в виде []
         */
        List<String> list = ImmutableList.of("aaa","","", "ddddd");
        String[] names = employees.stream().map(Employee::getName).toArray(String[]::new);
        System.out.println("toArray(String[]::new): "+Arrays.toString(names));

        /*
         * если результат нужно свести к результатирующей функции max,min, average, amount
         * Collectors.summarizingInt
         * Collectors.summarizingDouble
         * Collectors.summingDouble - отдельный метод для сохранения сумм
         */
        IntSummaryStatistics amounts = employees.stream()
                .map(Employee::getOld)
                .filter(amount -> amount > 0)
                .collect(Collectors.summarizingInt(Integer::new));
        System.out.println("Collectors.summarizingInt()");
        System.out.println("Sum: "+amounts.getSum());
        System.out.println("Average: "+amounts.getAverage());
        System.out.println("Min: "+amounts.getMin());
        System.out.println("Max: "+amounts.getMax());
        System.out.println("Count: "+amounts.getCount());

        /*
         * - Collectors.groupingBy();
         */
        Map<String, List<Employee>> mapsByGrouping =
                employees.stream().collect(Collectors.groupingBy(Employee::getCity));
        System.out.println("Collectors.groupingBy() for Elements: "+mapsByGrouping);


        Map<String, List<String>> mapsByGroupingForCity =
                employees.stream()
                        .collect(Collectors.groupingBy(Employee::getCity,
                                Collectors.mapping(Employee::getName, Collectors.toList())));
        System.out.println("Collectors.groupingBy() for City: "+mapsByGroupingForCity);

        Map<String, IntSummaryStatistics> mapAverageGroupingByCity =
                employees.stream()
                        .collect(Collectors.groupingBy(Employee::getCity,
                                Collectors.summarizingInt(Employee::getOld)));

        System.out.println("Collectors.groupingBy() Average Grouping By City: "+mapAverageGroupingByCity);

        /*
        * Нисходящие функции
        * */

        /*
         * - summing()
         */
        Map<String, Integer> mapSumming =
                employees.stream()
                        .collect(Collectors.groupingBy(Employee::getCity, Collectors.summingInt(Employee::getOld)));
        System.out.println("mapSumming: "+mapSumming);

        /*
         * - average()
         */
        Map<String, Double> mapAverage =
                employees.stream()
                        .collect(Collectors.groupingBy(Employee::getCity, Collectors.averagingInt(Employee::getOld)));
        System.out.println("mapAverage: "+mapAverage);

        /*
         * - maxBy()
         */
        Map<String, Optional<Employee>> mapMaxOld = employees.stream()
                .collect(Collectors.groupingBy(Employee::getCity,
                        Collectors.maxBy(Comparator.comparing(Employee::getOld))));
        System.out.println("Map older employee in City: "+mapMaxOld);

        /*
         * - mapping()
         * - получить какие то новые данные из Employee
         */
        Map<String, Optional<String>> mapMapping = employees.stream()
                .collect(Collectors.groupingBy(Employee::getCity,
                        Collectors.mapping(Employee::getName, Collectors.maxBy(Comparator.comparing(String::length)))));
        System.out.println("Map longer string length in name employee in City: "+mapMapping);

        /*
         * - mapping min By old
         */
        Map<String, Optional<Integer>> mapMinOld = employees.stream()
                .collect(Collectors.groupingBy(Employee::getCity,
                        Collectors.mapping(Employee::getOld, Collectors.minBy(Comparator.comparing(Integer::new)))));
        System.out.println("Min old  employee in City: "+mapMinOld);

        /*
         * - grouping and summarizing = summaryStatics
         */
        Map<String, IntSummaryStatistics> summaryStatics = employees.stream()
                .collect(Collectors.groupingBy(Employee::getCity, Collectors.summarizingInt(Employee::getOld)));
        System.out.println("summaryStatics: "+summaryStatics);

        /*
         * Группирование и разделение
         * Predicate выражение разделяыет на 2 листа, для true -> возвращает лист подходящий под условие
         *  и  false лист содержащий остальные значения
         * Collectors.partitioningBy();
         */
        Map<Boolean, List<Employee>> mapsByPartitioning =
                employees.stream()
                        .collect(Collectors.partitioningBy(emp -> emp.getCity().equals("Moscow")));
        System.out.println("Collectors.partitioningBy() from is Moscow false: "+mapsByPartitioning.get(false));
        System.out.println("Collectors.partitioningBy() from is Moscow true: "+mapsByPartitioning.get(true));


    }

    public static Predicate<Employee> predicateFilter1 = empl -> empl.getCity().equals("Yaroslavl");

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

    public static Function<Employee, String> funcTreeWord = new Function<Employee, String>() {
        @Override
        public String apply(Employee e) {
            return e.getCity().substring(0,3);
        }
    };

    public static Comparator<Integer> comp = new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2.compareTo(o1);
        }
    };

    public static class ComparatorEmployeeByOld implements Comparator<Employee> {
        @Override
        public int compare(Employee o1, Employee o2) {
            return  o1.getOld().compareTo(o2.getOld());
        }
    };

}
