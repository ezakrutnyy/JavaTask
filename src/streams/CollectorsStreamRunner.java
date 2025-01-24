package streams;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

import static java.util.function.UnaryOperator.identity;
import static streams.InitialStreamRunner.employees;

public class CollectorsStreamRunner {

    public static void main(String[] args) {
        System.out.println("-----------toList()---------------");
        // collect to list
        List<Employee> list = employees.stream()
                .filter(emp -> emp.getOld() > 45)
                .collect(Collectors.toList());
        System.out.println(list);

        System.out.println("------------toSet()-------------");
        // collect to set
        Set<Employee> set = employees.stream()
                .filter(emp -> emp.getOld() < 45)
                .collect(Collectors.toSet());
        System.out.println(set);


        System.out.println("-----------toCollection() TreeSet--------------");
        // collect to treeSet
        Set<Employee> treeSet = employees.stream()
                .filter(emp -> emp.getOld() < 45)
                .collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Employee::getOld)
                        .thenComparing(Employee::getName))));
        System.out.println(treeSet);

        System.out.println("-----------toCollection() LinkedList--------------");
        // collect to treeSet
        List<Employee> linkedList = employees.stream()
                .filter(emp -> emp.getOld() < 45)
                .collect(Collectors.toCollection(LinkedList::new));
        System.out.println(linkedList);


        System.out.println("----------toMap()#1--------------");
        // convert to map name => employee
        Map<String, Employee> mapByName = employees.stream()
                .collect(Collectors.toMap(Employee::getName, identity()));
        System.out.println(mapByName);

        System.out.println("----------toMap()#2--------------");
        // convert to map city => List<employee>
        Map<String, List<Employee>> mapByCityWithList = employees.stream().collect(Collectors.toMap(Employee::getCity,
                el -> new ArrayList<>(Collections.singletonList(el)), (el1, el2) -> {
                    el1.addAll(el2);
                    return el1;
                }));
        System.out.println(mapByCityWithList);

        System.out.println("-----------toMap()#3--------------");
        // convert to map city => Set<employee>, moreover keys sorting asc
        Map<String, Set<Employee>> mapByCity = employees.stream()
                .collect(
                        Collectors.toMap(
                                Employee::getCity,
                                Collections::singleton,
                                Sets::union,
                                TreeMap::new
                        )
                );
        System.out.println(mapByCity);

        // String values of cities via ; and sorted
        System.out.println("-----------joining()--------------");
        String cities = employees.stream()
                .map(Employee::getCity)
                .distinct()
                .sorted()
                .collect(Collectors.joining(";"));
        System.out.println(cities);

        // getting IntSummaryStatistics object via Collectors.summarizingInt
        System.out.println("-----------summarizingInt()--------------");
        IntSummaryStatistics intStatics = employees.stream()
                .collect(Collectors.summarizingInt(Employee::getOld));
        System.out.println(intStatics.getAverage());
        System.out.println(intStatics.getSum());
        System.out.println(intStatics.getMin());
        System.out.println(intStatics.getMax());


        // getting average olds for all employees
        System.out.println("-----------averagingInt()--------------");
        final Double average = employees.stream().collect(Collectors.averagingInt(Employee::getOld));
        System.out.println(average);

        // getting min old value for all employees
        System.out.println("-----------minBy()--------------");
        final Optional<Employee> minElem = employees.stream().collect(Collectors.minBy(Comparator.comparing(Employee::getOld)));
        System.out.println(minElem.get().getOld());

        // getting max old value for all employees
        System.out.println("-----------maxBy()--------------");
        final Optional<Employee> maxElem = employees.stream().collect(Collectors.maxBy(Comparator.comparing(Employee::getOld)));
        System.out.println(maxElem.get().getOld());

        // getting sum olds for all employees
        System.out.println("-----------summingInt()--------------");
        final Integer sum = employees.stream().collect(Collectors.summingInt(Employee::getOld));
        System.out.println(sum);

        // convert each element of collection Employee -> Name
        System.out.println("-----------groupingBy()--------------");
        final Map<String, List<Employee>> employeesByCity = employees.stream()
                .collect(Collectors.groupingBy(Employee::getCity));
        employeesByCity.values().stream()
                .flatMap(Collection::stream)
                .map(Employee::getName)
                .sorted()
                .forEach(System.out::println);

        System.out.println("-----------partitioningBy()--------------");
        final Map<Boolean, List<Employee>> employeesByCityPartitioningBy = employees.stream()
                .collect(Collectors.partitioningBy(el -> el.getOld() > 40));
        System.out.println(employeesByCityPartitioningBy);

        System.out.println("-----------reducing()--------------");
        Integer res = employees.stream()
                .collect(Collectors.reducing(0, el -> el.getOld(), Integer::sum));
        System.out.println(res);

        System.out.println("-----------collectingAndThen()--------------");
        Map<String, String> res2 = employees.stream().map(Employee::getCity).collect(Collectors
                .groupingBy(a -> a, Collectors.collectingAndThen(
                        Collectors.counting(),
                        count -> String.format("%.2f%%", (double) count / employees.size() * 100))));
        System.out.println(res2);

        System.out.println("-----------flatMapping()--------------");
        System.out.println("-----------mapping()--------------");
        Map<String, List<String>> res3 = employees.stream().collect(Collectors.groupingBy(Employee::getCity,
                Collectors.mapping(Employee::getName, Collectors.toList())));
        System.out.println(res3);
    }
}