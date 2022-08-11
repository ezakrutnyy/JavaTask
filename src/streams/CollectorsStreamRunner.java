package streams;

import com.google.common.collect.Sets;

import java.util.*;
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


        System.out.println("-----------toCollection()--------------");
        // collect to treeSet
        Set<Employee> treeSet = employees.stream()
                .filter(emp -> emp.getOld() < 45)
                .collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Employee::getOld)
                        .thenComparing(Employee::getName))));
        System.out.println(treeSet);


        System.out.println("----------toMap()#1--------------");
        // convert to map name => employee
        Map<String, Employee> mapByName = employees.stream()
                .collect(Collectors.toMap(Employee::getName, identity()));
        System.out.println(mapByName);

        System.out.println("-----------toMap()#2--------------");
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

    }
}