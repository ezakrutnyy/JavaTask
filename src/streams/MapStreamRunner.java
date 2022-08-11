package streams;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static streams.InitialStreamRunner.employees;

public class MapStreamRunner {

    public static void main(String[] args) {

        System.out.println("--------------------------");
        // convert each element of collection Employee -> Name
        employees.stream()
                .map(Employee::getName)
                .sorted()
                .forEach(System.out::println);

        System.out.println("--------------------------");
        // convert each element of collection Employee -> Name
        final Map<String, List<Employee>> employeesByCity = employees.stream()
                .collect(Collectors.groupingBy(Employee::getCity));
        employeesByCity.values().stream()
                .flatMap(Collection::stream)
                .map(Employee::getName)
                .sorted()
                .forEach(System.out::println);
    }
}
