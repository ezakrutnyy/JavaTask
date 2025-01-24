package streams;

import java.util.Optional;

import static streams.InitialStreamRunner.employees;

public class ReduceStreamRunner {

    public static void main(String[] args) {
        System.out.println("--------reduce()--------------");
        Optional<Integer> reduceSum = employees.stream()
                .map(Employee::getOld)
                .reduce(Integer::sum);
        System.out.println("reduceSum old: " + reduceSum.orElse(0));

        System.out.println("---------reduce() with identity---------------");
        Integer reduceSumInteger = employees.stream()
                .map(Employee::getOld)
                .reduce(0, Integer::sum);
        System.out.println("reduceSum old or 0: " + reduceSumInteger);
    }
}