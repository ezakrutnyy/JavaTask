package abstractAndInterfaces.functional;

import com.google.common.collect.Lists;
import streams.Employee;

import java.util.List;
import java.util.function.UnaryOperator;

public class UnaryOperatorDemo {

    public static void main(String[] args) {
        List<Employee> employes = Lists.newArrayList(
                new Employee("Bruce","Boston", 43),
                new Employee("Crew", "Florida", 32)
        );

        employes.stream().map(modifyOlderConst).forEach(System.out::println);
    }

    public static UnaryOperator<Employee> modifyOlderConst = emp -> {
        emp.setOld(18);
        return emp;
    };

}
