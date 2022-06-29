package streams;

import static streams.InitialStreamRunner.employees;

public class TerminalStreamRunner {

    public static void main(String[] args) {

        System.out.println("--------------------------");
        // get any young person from Yaroslavl
        final Employee youngEmployee = employees.stream()
                .filter(emp -> emp.getOld() < 30 && "Yaroslavl".equals(emp.getCity()))
                .findAny()
                .orElse(null);
        System.out.println(youngEmployee);


        System.out.println("--------------------------");
        // get first legal person from Moscow
        final Employee firstLegalEmployee = employees.stream()
                .filter(emp -> emp.getOld() >= 18 && "Moscow".equals(emp.getCity()))
                .findFirst()
                .orElse(null);
        System.out.println(firstLegalEmployee);
    }
}
