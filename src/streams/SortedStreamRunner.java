package streams;

import java.util.Comparator;

import static streams.InitialStreamRunner.employees;

public class SortedStreamRunner {

    public static void main(String[] args) {

        // sorted by old asc
        System.out.println("--------------------------");
        employees.stream().sorted(Comparator.comparing(Employee::getOld)).forEach(System.out::println);

        // sorted by old desc
        System.out.println("--------------------------");
        employees.stream().sorted(Comparator.comparing(Employee::getOld).reversed()).forEach(System.out::println);

        // sorted by count symbols of employee name and then by old
        System.out.println("--------------------------");
        final Comparator<Employee> countSymbolsComparator = Comparator.comparing(emp -> emp.getName().length());
        employees.stream().sorted(countSymbolsComparator.thenComparing(Employee::getOld)).forEach(System.out::println);
    }
}
