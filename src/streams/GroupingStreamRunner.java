package streams;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;
import static streams.InitialStreamRunner.employees;

public class GroupingStreamRunner {

    public static void main(String[] args) {

        System.out.println("-----------groupingBy()-------------");
        // getting set of grouping map by city
        Map<String, Set<Employee>> mapByCity = employees.stream()
                .collect(Collectors.groupingBy(Employee::getCity, toSet()));
        System.out.println(mapByCity);

        /* Downstream function */

        System.out.println("-----------groupingBy(), counting()-------------");
        Map<String, Long> mapCountsCities = employees.stream()
                .collect(Collectors.groupingBy(Employee::getCity, counting()));
        System.out.println(mapCountsCities);

        System.out.println("-----------groupingBy(), summingInt()-------------");
        Map<String, Integer> mapSummaryOlds = employees.stream()
                .collect(Collectors.groupingBy(Employee::getCity, summingInt(Employee::getOld)));
        System.out.println(mapSummaryOlds);

        System.out.println("-----------groupingBy(), averagingInt()-------------");
        Map<String, Double> mapAverageOlds = employees.stream()
                .collect(Collectors.groupingBy(Employee::getCity, averagingInt(Employee::getOld)));
        System.out.println(mapAverageOlds);

        System.out.println("-----------groupingBy(), minBy()-------------");
        Map<String, Optional<Employee>> mapMinOlds = employees.stream()
                .collect(Collectors.groupingBy(Employee::getCity, minBy(Comparator.comparing(Employee::getOld))));
        System.out.println(mapMinOlds);

        System.out.println("-----------groupingBy(), maxBy()-------------");
        Map<String, Optional<Employee>> mapMaxOlds = employees.stream()
                .collect(Collectors.groupingBy(Employee::getCity, maxBy(Comparator.comparing(Employee::getOld))));
        System.out.println(mapMaxOlds);


        System.out.println("-----------groupingBy(), mapping(), maxBy()-------------");
        Map<String, Optional<Integer>> mapMaxOldsIntegerPresent = employees.stream()
                .collect(Collectors.groupingBy(Employee::getCity,
                        mapping(Employee::getOld, maxBy(Integer::compareTo))));
        System.out.println(mapMaxOldsIntegerPresent);

        System.out.println("-----------groupingBy(), mapping(), toSet()-------------");
        Map<String, Set<String>> mappingNames = employees.stream()
                .collect(Collectors.groupingBy(Employee::getCity,
                        mapping(Employee::getName, toSet())));
        System.out.println(mappingNames);

        System.out.println("-----------partitioningBy()-------------");
        Map<Boolean, String> mapsByPartitioning =
                employees.stream()
                        .collect(Collectors.partitioningBy(emp -> emp.getCity().equals("Moscow"), mapping(Employee::getName, joining(","))));
        System.out.println("Collectors.partitioningBy() from is Moscow false: " + mapsByPartitioning.get(false));
        System.out.println("Collectors.partitioningBy() from is Moscow true: " + mapsByPartitioning.get(true));
    }
}
