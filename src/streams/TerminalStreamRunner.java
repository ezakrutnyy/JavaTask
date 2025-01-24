package streams;

import java.util.Random;

import static streams.InitialStreamRunner.employees;

public class TerminalStreamRunner {
    public static void main(String[] args) {
        System.out.println("-------findAny---------------");
        // get any young person from Yaroslavl
        final Employee youngEmployee = employees.stream()
                .filter(emp -> emp.getOld() < 30 && "Yaroslavl".equals(emp.getCity()))
                .findAny()
                .orElse(null);
        System.out.println(youngEmployee);

        System.out.println("---------findFirst--------------");
        // get first legal person from Moscow
        final Employee firstLegalEmployee = employees.stream()
                .filter(emp -> emp.getOld() >= 18 && "Moscow".equals(emp.getCity()))
                .findFirst()
                .orElse(null);
        System.out.println(firstLegalEmployee);

        System.out.println("--------forEach------------");
        // foreach via collection of elements
        employees.forEach(System.out::println);

        System.out.println("---------peek----------");
        // modify old to random  value (0-33) for each elements of collection
        employees.stream()
                .peek(el -> el.setOld(new Random().nextInt(100)))
                .forEach(System.out::println);
    }
}