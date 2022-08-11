package streams;

import static streams.InitialStreamRunner.employees;

public class BoundingStreamRunner {

    public static void main(String[] args) {

        System.out.println("--------------------------");
        // count elements of collection
        long count = employees.stream().filter(emp -> emp.getOld() > 20).count();
        System.out.println(count);

        System.out.println("--------------------------");
        // bounding limit 3 person
        employees.stream().filter(emp -> emp.getOld() > 20).limit(3).forEach(System.out::println);

        System.out.println("--------------------------");
        // skip 3 person
        employees.stream().filter(emp -> emp.getOld() > 20).skip(2).forEach(System.out::println);


        System.out.println("--------------------------");
        // remove duplicate elements from collection
        Employee empCopy = employees.get(0); // Alex
        employees.add(empCopy);
        employees.add(empCopy);
        employees.add(empCopy);
        employees.add(empCopy);
        employees.stream().filter(emp -> "Alex".equals(emp.getName())).distinct().forEach(System.out::println);
    }
}
