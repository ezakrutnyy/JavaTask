package streams;


import com.google.common.collect.Sets;

import java.util.Comparator;
import java.util.Set;
import java.util.stream.Stream;

import static streams.InitialStreamRunner.employees;

public class ConcatStreamRunner {

    public static void main(String[] args) {
        final Set<Employee> newJoiners = Sets.newHashSet(new Employee("Cougar", "Peresvet", 55));
        Stream.concat(employees.stream(), newJoiners.stream())
                .sorted(Comparator.comparing(Employee::getName))
                .forEach(System.out::println);
    }
}
