package abstractAndInterfaces.functional;

import com.google.common.collect.Lists;
import streams.Employee;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class ConsumerDemo {

    public static void main(String[] args) {
        List<Employee> employes = Lists.newArrayList(
                new Employee("Bruce","Boston", 43),
                new Employee("Crew", "Florida", 32),
                new Employee("Andrew", "New-York", 15),
                new Employee("Albert", "Ohaio", 18),
                new Employee("Mattew", "Yaroslavl", 29)
        );

        List<String> names = employes.stream().map(Employee::getName).collect(Collectors.toList());
        modifyList.andThen(printNameList).accept(names);
    }

    public static Consumer<String> printName = name -> System.out.println("NAME: "+name);

    public static Consumer<List<String>> printNameList = list -> list.stream().forEach(System.out::println);

    public static Consumer<List<String>> modifyList = list -> {
        for (int i = 0; i < list.size(); i++) {
            list.set(i, list.get(i)+"_FIRST");
        }
    };
}
