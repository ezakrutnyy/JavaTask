package streams;

import java.util.Comparator;

import static streams.InitialStreamRunner.employees;

public class MinAndMaxStreamRunner {

    public static void main(String[] args) {

        // finding element with min value of age
        System.out.println("--------------------------");
        final Employee emp1 = employees.stream()
                .min(Comparator.comparing(Employee::getOld)).orElseThrow(() -> new RuntimeException("Min element not found!"));
        System.out.println(emp1);

        // finding element with max value of age
        System.out.println("--------------------------");
        final Employee emp2 = employees.stream()
                .max(Comparator.comparing(Employee::getOld)).orElseThrow(() -> new RuntimeException("Max element not found!"));
        System.out.println(emp2);
    }
}
