package abstractAndInterfaces.functional;

import streams.Employee;

import java.util.Comparator;

public class ComparatorDemo {


    public static Comparator<Employee> compInterfaceEmployeOld =
            Comparator.comparing(Employee::getOld);

    public static Comparator<Integer> compMethodEmployeOld = Comparator.reverseOrder();


}
