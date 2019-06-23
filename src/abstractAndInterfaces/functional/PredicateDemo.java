package abstractAndInterfaces.functional;

import com.google.common.collect.Lists;
import com.google.common.collect.Range;
import streams.Employee;

import java.util.List;
import java.util.function.Predicate;

public class PredicateDemo {

    public static void main(String[] args) {
        List<Employee> employes = Lists.newArrayList(
                new Employee("Bruce","Boston", 43),
                new Employee("Crew", "Florida", 32),
                new Employee("Andrew", "New-York", 15),
                new Employee("Albert", "Ohaio", 18),
                new Employee("Mattew", "Yaroslavl", 29)
        );

        System.out.println("************************************************************************");

        employes.stream()
                .filter(predicateYar)
                .map(Employee::getName)
                .forEach(System.out::println);

        System.out.println("************************************************************************");

        employes.stream()
                .filter(predicateOld.and(predicateNameSrartWithA))
                .map(Employee::getName)
                .forEach(System.out::println);

        System.out.println("************************************************************************");

        employes.stream()
                .filter(predicateYar.or(predicateOld))
                .map(Employee::getName)
                .forEach(System.out::println);

        System.out.println("************************************************************************");

        employes.stream()
                .filter(predicateYar.negate())
                .map(Employee::getName)
                .forEach(System.out::println);
    }

    public static Predicate<Employee> predicateYar =
            (emp) -> emp.getCity().equals("Yaroslavl");

    public static Predicate<Employee> predicateOld = emp -> {
        Integer old = emp.getOld();
        Range range =  Range.closedOpen(0, 18);
        return  range.test(old);
    };

    public static Predicate<Employee> predicateNameSrartWithA = emp -> {
        String name = emp.getName();
        return name.startsWith("A");
    };
}
