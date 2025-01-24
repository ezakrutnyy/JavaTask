package streams;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.RandomUtils;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static abstractAndInterfaces.functional.ComparatorDemo.compInterfaceEmployeOld;
import static abstractAndInterfaces.functional.ConsumerDemo.printName;
import static abstractAndInterfaces.functional.FunctionDemo.funcTreeChars;
import static abstractAndInterfaces.functional.PredicateDemo.predicateNameSrartWithA;
import static abstractAndInterfaces.functional.PredicateDemo.predicateOld;
import static abstractAndInterfaces.functional.PredicateDemo.predicateYar;

/**
 * Java Stream API предлагает два вида методов:
 * 1. Конвейерные — возвращают другой stream, то есть работают как builder,
 * 2. Терминальные — возвращают другой объект, такой как коллекция, примитивы, объекты, Optional и т.д.
 * <p>
 * *****************************************************************************************************************
 * Краткое описание конвейерных методов работы со стримами:
 * <p>
 * filter
 * Отфильтровывает записи, возвращает только записи, соответствующие условию
 * collection.stream().filter(«a1»::equals).count()
 * <p>
 * skip
 * Позволяет пропустить N первых элементов
 * collection.stream().skip(collection.size() — 1).findFirst().orElse(«1»)
 * <p>
 * distinct
 * Возвращает стрим без дубликатов (для метода equals)
 * collection.stream().distinct().collect(Collectors.toList())
 * <p>
 * map
 * Преобразует каждый элемент стрима
 * collection.stream().map((s) -> s + "_1").collect(Collectors.toList())
 * <p>
 * peek
 * Возвращает тот же стрим, но применяет функцию к каждому элементу стрима
 * collection.stream().map(String::toUpperCase).peek((e) -> System.out.print("," + e)).collect(Collectors.toList())
 * <p>
 * limit
 * Позволяет ограничить выборку определенным количеством первых элементов
 * collection.stream().limit(2).collect(Collectors.toList())
 * <p>
 * sorted
 * Позволяет сортировать значения либо в натуральном порядке, либо задавая Comparator
 * collection.stream().sorted().collect(Collectors.toList())
 * <p>
 * mapToInt,
 * mapToDouble,
 * mapToLong
 * Аналог map, но возвращает числовой стрим (то есть стрим из числовых примитивов)
 * collection.stream().mapToInt((s) -> Integer.parseInt(s)).toArray()
 * <p>
 * flatMap,
 * flatMapToInt,
 * flatMapToDouble,
 * flatMapToLong
 * Похоже на map, но может создавать из одного элемента несколько
 * collection.stream().flatMap((p) -> Arrays.asList(p.split(",")).stream()).toArray(String[]::new)
 * <p>
 * <p>
 * ******************************************************************************************************************
 * Краткое описание терминальных методов работы со стримами
 * <p>
 * findFirst
 * Возвращает первый элемент из стрима (возвращает Optional)
 * collection.stream().findFirst().orElse(«1»)
 * <p>
 * <p>
 * findAny
 * Возвращает любой подходящий элемент из стрима (возвращает Optional)
 * collection.stream().findAny().orElse(«1»)
 * <p>
 * <p>
 * collect	Представление результатов в виде коллекций и других структур данных
 * collection.stream().filter((s) -> s.contains(«1»)).collect(Collectors.toList())
 * <p>
 * count
 * Возвращает количество элементов в стриме
 * collection.stream().filter(«a1»::equals).count()
 * <p>
 * anyMatch
 * Возвращает true, если условие выполняется хотя бы для одного элемента
 * collection.stream().anyMatch(«a1»::equals)
 * <p>
 * noneMatch
 * Возвращает true, если условие не выполняется ни для одного элемента
 * collection.stream().noneMatch(«a8»::equals)
 * <p>
 * allMatch
 * Возвращает true, если условие выполняется для всех элементов
 * collection.stream().allMatch((s) -> s.contains(«1»))
 * <p>
 * min
 * Возвращает минимальный элемент, в качестве условия использует компаратор
 * collection.stream().min(String::compareTo).get()
 * <p>
 * max
 * Возвращает максимальный элемент, в качестве условия использует компаратор
 * collection.stream().max(String::compareTo).get()
 * <p>
 * forEach
 * Применяет функцию к каждому объекту стрима, порядок при параллельном выполнении не гарантируется
 * set.stream().forEach((p) -> p.append("_1"));
 * <p>
 * forEachOrdered
 * Применяет функцию к каждому объекту стрима, сохранение порядка элементов гарантирует
 * list.stream().forEachOrdered((p) -> p.append("_new"));
 * <p>
 * toArray
 * Возвращает массив значений стрима
 * collection.stream().map(String::toUpperCase).toArray(String[]::new);
 * <p>
 * reduce
 * Позволяет выполнять агрегатные функции на всей коллекцией и возвращать один результат
 * collection.stream().reduce((s1, s2) -> s1 + s2).orElse(0)
 * <p>
 * ******************************************************************************************************************
 * <p>
 * Краткое описание дополнительных методов у числовых стримов
 * <p>
 * sumRecursive
 * Возвращает сумму всех чисел
 * collection.stream().mapToInt((s) -> Integer.parseInt(s)).sumRecursive()
 * <p>
 * average
 * Возвращает среднее арифметическое всех чисел
 * collection.stream().mapToInt((s) -> Integer.parseInt(s)).average()
 * <p>
 * mapToObj
 * Преобразует числовой стрим обратно в объектный
 * intStream.mapToObj((id) -> new Key(id)).toArray()
 * <p>
 * ******************************************************************************************************************
 * <p>
 * Несколько других полезных методов стримов
 * isParallel
 * Узнать является ли стрим параллельным
 * <p>
 * <p>
 * parallel
 * Вернуть параллельный стрим, если стрим уже параллельный, то может вернуть самого себя
 * <p>
 * sequential
 * Вернуть последовательный стрим, если стрим уже последовательный, то может вернуть самого себя
 * <p>
 * <p>
 * ******************************************************************************************************************
 * <p>
 * Давайте рассмотрим статические методы из Collectors:
 * Метод	Описание
 * <p>
 * toList, toCollection, toSet	                                представляют стрим в виде списка, коллекции или множества
 * toConcurrentMap, toMap	                                    позволяют преобразовать стрим в map
 * averagingInt, averagingDouble, averagingLong	                возвращают среднее значение
 * summingInt, summingDouble, summingLong	                    возвращает сумму
 * summarizingInt, summarizingDouble, summarizingLong	        возвращают SummaryStatistics с разными агрегатными значениями
 * partitioningBy	                                            разделяет коллекцию на две части по соответствию условию и
 * возвращает их как Map<Boolean, List>
 * groupingBy	                                                разделяет коллекцию на несколько частей и возвращает Map<N, List<T>>
 * mapping	                                                    дополнительные преобразования значений для сложных Collector'ов
 * <p>
 * *
 */
public class StreamExample {
    public static void main(String[] args) {

        List<Employee> employees = Lists.newArrayList(
                new Employee("Alex", "Moscow", 22),
                new Employee("Max", "Kursk", 55),
                new Employee("Tom", "Moscow", 10),
                new Employee("Carl", "Moscow", 44),
                new Employee("Sam", "Voronezh", 26),
                new Employee("Fox", "Yaroslavl", 27),
                new Employee("Ronald", "Moscow", 19),
                new Employee("Mike", "Yaroslavl", 23),
                new Employee("Arche", "Tula", 23)
        );

        System.out.println("**************************************************************************");
        System.out.println(" Примеры использования filter, findFirst, findAny, skip, limit и count");
        System.out.println("**************************************************************************");

        System.out.println("limit()");
        employees.stream()
                .filter(predicateNameSrartWithA)
                .map(Employee::getName)
                .limit(2)
                .forEach(printName);

        System.out.println("skip()");
        employees.stream()
                .skip(2)
                .map(funcTreeChars)
                .forEach(printName);

        System.out.println("findAny()");
        String nameAny = employees.stream().filter(predicateNameSrartWithA)
                .findAny()
                .map(Employee::getName)
                .orElse("mister n");
        System.out.println(nameAny);

        System.out.println("findFirst()");
        String nameFirst = employees.stream().filter(predicateNameSrartWithA)
                .findFirst()
                .map(Employee::getName)
                .orElse("mister n");
        System.out.println(nameFirst);

        System.out.println("**************************************************************************");
        System.out.println(" Примеры использования Match функций (anyMatch, allMatch, noneMatch)");
        System.out.println("**************************************************************************");

        System.out.println("anyMatch()");
        boolean flag = employees.stream().anyMatch(predicateOld);
        System.out.println(flag);

        System.out.println("allMatch()");
        flag = employees.stream().allMatch(predicateOld);
        System.out.println(flag);

        System.out.println("noneMatch()");
        flag = employees.stream().noneMatch(predicateOld);
        System.out.println(flag);

        System.out.println("**************************************************************************");
        System.out.println(" Примеры использования Map функций (map, mapToInt, mapToDouble, mapToLong, " +
                "flatMap, flatMapToInt)");
        System.out.println("**************************************************************************");

        List<List<String>> deepLists = Lists.newArrayList(
                Lists.newArrayList("zak", "mak"),
                Lists.newArrayList("rak", "dac"),
                Lists.newArrayList("mirror", "bolk")
        );

        System.out.println("flatMap()");
        String strDep = deepLists.stream().flatMap(Collection::stream).collect(Collectors.joining(","));
        List<String> listDep = deepLists.stream().flatMap(Collection::stream).collect(Collectors.toList());
        System.out.println(strDep);
        System.out.println(listDep);

        System.out.println("flatMap()");
        Collection<String> collection = Arrays.asList("1,2,0", "4,5");
        String[] number = collection.stream()
                .flatMap(p -> Arrays.stream(p.split(",")))
                .toArray(String[]::new);
        System.out.println(Arrays.toString(number));

        System.out.println("flatMapToInt()");
        int sum = collection.stream()
                .flatMapToInt(p -> Arrays.stream(p.split(","))
                        .mapToInt(Integer::parseInt)).sum();
        System.out.println(sum);

        System.out.println("map()");
        employees.stream().filter(predicateYar).map(Employee::getName).forEach(printName);

        /*
         * Объект IntStream, после применения результатирующей функции, вохвращает примитив int
         * */
        System.out.println("intStream: sumRecursive: " + employees.stream().mapToInt(Employee::getOld).sum());
        System.out.println("intStream: average: " + employees.stream().mapToInt(Employee::getOld).average());
        System.out.println("intStream: max element: " + employees.stream().mapToInt(Employee::getOld).max());
        System.out.println("intStream: min element: " + employees.stream().mapToInt(Employee::getOld).min());
        System.out.println("mapToInt is int[] :" + Arrays.toString(employees.stream().mapToInt(Employee::getOld).toArray()));

        System.out.println("**************************************************************************");
        System.out.println(" Примеры использования distinct()");
        System.out.println("**************************************************************************");

        employees.stream().distinct().map(Employee::getName).forEach(printName);

        System.out.println("**************************************************************************");
        System.out.println(" Примеры использования Sorted()");
        System.out.println("**************************************************************************");

        List<Employee> sortedEmployeeList = employees.stream()
                .sorted(compInterfaceEmployeOld)
                .collect(Collectors.toList());

        System.out.println("sortedEmployeeList by old: " + sortedEmployeeList);

        sortedEmployeeList = employees.stream()
                .sorted(Comparator.comparing(Employee::getCity))
                .collect(Collectors.toList());

        System.out.println("sortedEmployeeList by city: " + sortedEmployeeList);


        System.out.println("**************************************************************************");
        System.out.println(" Примеры использования Max и Min функций");
        System.out.println("**************************************************************************");

        Integer minOld = employees.stream()
                .map(Employee::getOld)
                .min(Integer::compareTo)
                .orElse(0);
        System.out.println("Min old: " + minOld);

        String maxCity = employees.stream()
                .map(Employee::getCity)
                .max(String::compareTo)
                .orElse("");
        System.out.println("Max City: " + maxCity);

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

        Optional<Integer> reduceSum = employees.stream()
                .map(Employee::getOld)
                .reduce(Integer::sum);
        System.out.println("reduceSum old: " + reduceSum.orElse(0));

        Integer reduceSummInteger = employees.stream()
                .map(Employee::getOld)
                .reduce(0, Integer::sum);
        System.out.println("reduceSum old or 0: " + reduceSummInteger);


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
        System.out.println("Collectors.joining: " + resJoinWithSeparator);

        /*
         * - toArray(String[]::new)
         * - Возврат результата в виде []
         */
        List<String> list = ImmutableList.of("aaa", "", "", "ddddd");
        String[] names = employees.stream().map(Employee::getName).toArray(String[]::new);
        System.out.println("toArray(String[]::new): " + Arrays.toString(names));

        /*
         * если результат нужно свести к результатирующей функции max,min, average, amount
         * Collectors.summarizingInt
         * Collectors.summarizingDouble
         * Collectors.summingDouble - отдельный метод для сохранения сумм
         */
        IntSummaryStatistics amounts = employees.stream()
                .filter(employee -> employee.getOld() > 0)
                .collect(Collectors.summarizingInt(Employee::getOld));
        System.out.println("Collectors.summarizingInt()");
        System.out.println("Sum: " + amounts.getSum());
        System.out.println("Average: " + amounts.getAverage());
        System.out.println("Min: " + amounts.getMin());
        System.out.println("Max: " + amounts.getMax());
        System.out.println("Count: " + amounts.getCount());

        /*
         * - Collectors.groupingBy();
         */
        Map<String, List<Employee>> mapsByGrouping =
                employees.stream().collect(Collectors.groupingBy(Employee::getCity));
        System.out.println("Collectors.groupingBy() for Elements: " + mapsByGrouping);

        Map<String, List<String>> mapsByGroupingForCity =
                employees.stream()
                        .collect(Collectors.groupingBy(Employee::getCity,
                                Collectors.mapping(Employee::getName, Collectors.toList())));
        System.out.println("Collectors.groupingBy() for City: " + mapsByGroupingForCity);

        /*
         * Нисходящие функции
         * */

        /*
         * - summing()
         */
        Map<String, Integer> mapSumming =
                employees.stream()
                        .collect(Collectors.groupingBy(Employee::getCity, Collectors.summingInt(Employee::getOld)));
        System.out.println("mapSumming: " + mapSumming);

        /*
         * - average()
         */
        Map<String, Double> mapAverage =
                employees.stream()
                        .collect(Collectors.groupingBy(Employee::getCity, Collectors.averagingInt(Employee::getOld)));
        System.out.println("mapAverage: " + mapAverage);

        /*
         * - maxBy()
         */
        Map<String, Optional<Employee>> mapMaxOld = employees.stream()
                .collect(Collectors.groupingBy(Employee::getCity,
                        Collectors.maxBy(Comparator.comparing(Employee::getOld))));
        System.out.println("Map older employee in City: " + mapMaxOld);

        /*
         * - mapping()
         * - получить какие то новые данные из Employee
         */
        Map<String, Optional<String>> mapMapping = employees.stream()
                .collect(Collectors.groupingBy(Employee::getCity,
                        Collectors.mapping(Employee::getName, Collectors.maxBy(Comparator.comparing(String::length)))));
        System.out.println("Map longer string length in name employee in City: " + mapMapping);

        /*
         * - mapping min By old
         */
        Map<String, Optional<Integer>> mapMinOld = employees.stream()
                .collect(Collectors.groupingBy(Employee::getCity,
                        Collectors.mapping(Employee::getOld, Collectors.minBy(Comparator.comparing(Integer::new)))));
        System.out.println("Min old  employee in City: " + mapMinOld);

        /*
         * - grouping and summarizing = summaryStatics
         */
        Map<String, IntSummaryStatistics> summaryStatics = employees.stream()
                .collect(Collectors.groupingBy(Employee::getCity, Collectors.summarizingInt(Employee::getOld)));
        System.out.println("summaryStatics: " + summaryStatics);

        /*
         * Группирование и разделение
         * Predicate выражение разделяыет на 2 листа, для true -> возвращает лист подходящий под условие
         *  и  false лист содержащий остальные значения
         * Collectors.partitioningBy();
         */
        Map<Boolean, List<Employee>> mapsByPartitioning =
                employees.stream()
                        .collect(Collectors.partitioningBy(emp -> emp.getCity().equals("Moscow")));
        System.out.println("TODO Collectors.partitioningBy() from is Moscow false: " + mapsByPartitioning.get(false));
        System.out.println("TODO Collectors.partitioningBy() from is Moscow true: " + mapsByPartitioning.get(true));

        /**
         * Compress  map
         * Получение из List<Map<String, List<Element>>> , Map <String, List<Element>>
         */
        List<Map<String, List<TransactionStream>>> transactions = Lists.newArrayList();

        Map<String, List<TransactionStream>> maps = Maps.newHashMap();
        maps.put("99", Lists.newArrayList(new TransactionStream(1L, new BigDecimal(100))));
        maps.put("22", Lists.newArrayList(new TransactionStream(2L, new BigDecimal(344))));
        maps.put("55", Lists.newArrayList(new TransactionStream(3L, new BigDecimal(150))));
        transactions.add(maps);

        Map<String, List<TransactionStream>> maps2 = Maps.newHashMap();
        maps2.put("99", Lists.newArrayList(new TransactionStream(5L, new BigDecimal(666))));
        maps2.put("22", Lists.newArrayList(new TransactionStream(23L, new BigDecimal(777))));
        transactions.add(maps2);

        Map<String, List<TransactionStream>> maps3 = Maps.newHashMap();
        maps3.put("22", Lists.newArrayList(new TransactionStream(100L, new BigDecimal(90))));
        maps3.put("55", Lists.newArrayList(new TransactionStream(300L, new BigDecimal(26))));

        transactions.add(maps3);

        Map<String, List<TransactionStream>> res = collapseFlatMap(transactions);
        System.out.println("CollapseFlatMap:" + res);


        /**
         * collapseFlatMap  map
         * Получение из List<Map<Integer, Integer>>, Map<Integer, Integer>, где значения, с одинаковыми ключами суммируются
         */

        Map<Integer, Integer> nodeInstance1 = Maps.newHashMap();
        nodeInstance1.put(1, 10);
        nodeInstance1.put(2, 33);
        nodeInstance1.put(3, 12);
        nodeInstance1.put(4, 9);

        Map<Integer, Integer> nodeInstance2 = Maps.newHashMap();
        nodeInstance2.put(1, 5);
        nodeInstance2.put(2, 7);
        nodeInstance2.put(3, 7);

        Map<Integer, Integer> nodeInstance3 = Maps.newHashMap();
        nodeInstance3.put(1, 22);
        nodeInstance3.put(2, 13);
        nodeInstance3.put(3, 10);

        Map<Integer, Integer> nodeInstance4 = Maps.newHashMap();
        nodeInstance4.put(1, 5);
        nodeInstance4.put(2, 3);
        nodeInstance4.put(3, 1);

        List<Map<Integer, Integer>> nodes = Lists.newArrayList(nodeInstance1, nodeInstance2, nodeInstance3, nodeInstance4);
        Map<Integer, Integer> nodesResult = collapseFlatMapWithSumValue(nodes);
        System.out.println("CollapseFlatMapWithSumValue: " + nodesResult);

    }

    public static <T, S> Map<T, List<S>> collapseFlatMap(List<Map<T, List<S>>> list) {
        Map<T, List<S>> result = list.stream().flatMap(map -> map.entrySet().stream())
                .collect(Collectors.toMap(Map.Entry::getKey,
                        Map.Entry::getValue,
                        (l1, l2) -> Stream.concat(l1.stream(), l2.stream()).collect(Collectors.toList())));
        return result;
    }

    public static Map<Integer, Integer> collapseFlatMapWithSumValue(List<Map<Integer, Integer>> nodes) {
        return nodes.stream().flatMap(map -> map.entrySet().stream())
                .collect(Collectors.toMap(Map.Entry::getKey,
                        Map.Entry::getValue, Integer::sum));
    }


}

class TransactionStream {

    private Long id;

    private BigDecimal amount;

    public TransactionStream(Long id, BigDecimal amount) {
        this.id = id;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "TransactionStream{" +
                "id=" + id +
                ", amount=" + amount +
                '}';
    }
}