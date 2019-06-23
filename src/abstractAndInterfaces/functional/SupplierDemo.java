package abstractAndInterfaces.functional;

import com.google.common.collect.Lists;
import streams.Employee;

import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

import static abstractAndInterfaces.functional.PredicateDemo.predicateOld;

public class SupplierDemo {

    public static void main(String[] args) {
        List<Employee> employes = Lists.newArrayList(
                new Employee("Bruce","Boston", 43),
                new Employee("Crew", "Florida", 32),
                new Employee("Mattew", "Yaroslavl", 29)
        );

        Employee empNew = employes.stream()
                .filter(predicateOld)
                .findFirst()
                .orElseGet(defaultEmployee);
        System.out.println("Employee :"+empNew);

    }

    public static Supplier<Employee> defaultEmployee = () -> new Employee("Test", "Test", 100);

    // генератор постойнной строки Echo
    public static Supplier<String> generateConstStr = () -> "Test";

    // генератор случайного целого числа [1-100]
    public static Supplier<Integer> generateRandomInteger = () -> new Random().nextInt(100);

}
