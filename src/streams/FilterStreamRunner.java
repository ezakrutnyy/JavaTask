package streams;

import java.util.function.Predicate;

import static streams.InitialStreamRunner.employees;

public class FilterStreamRunner {

    public static void main(String[] args) {

        final Predicate<Employee> filterByAge = emp -> emp.getOld() < 30;

        System.out.println("--------------------------");
        // Search ALL young person
        employees.stream().filter(filterByAge).forEach(System.out::println);

        System.out.println("--------------------------");
        // Is ANY person from Yaroslavl
        boolean isAnyMatch = employees.stream().anyMatch(emp -> "Yaroslavl".equals(emp.getCity()));
        System.out.println(isAnyMatch);

        System.out.println("--------------------------");
        // Are All person, have length of name at least 3 characters
        boolean isAllMatch = employees.stream().allMatch(emp -> emp.getName().length() >= 3);
        System.out.println(isAllMatch);

        System.out.println("--------------------------");
        // Has no any person, who's name start of character "F"
        boolean isNoneMatch = employees.stream().noneMatch(emp -> emp.getName().startsWith("F"));
        System.out.println(isNoneMatch);
    }
}
