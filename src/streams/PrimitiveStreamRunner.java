package streams;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.stream.Stream;

import static streams.InitialStreamRunner.employees;

public class PrimitiveStreamRunner {

    public static void main(String[] args) {
        /*
         * After applying primitive stream methods like 'mapToInt', 'mapToLong', 'mapToDouble', we get objects
         * IntStream, LongStream, DoubleStream  and then we can call different methods for primitive stream
         * like 'count', 'sum', 'average', 'min', 'max'
         * */
        System.out.println("--------------------------");
        final double average = employees.stream().mapToInt(Employee::getOld).average().orElse(0);
        System.out.println(average);

        System.out.println("--------------------------");
        final int minValue = employees.stream().mapToInt(Employee::getOld).min().orElse(0);
        System.out.println(minValue);

        System.out.println("--------------------------");
        final int maxValue = employees.stream().mapToInt(Employee::getOld).max().orElse(0);
        System.out.println(maxValue);

        System.out.println("--------------------------");
        final int sum = employees.stream().mapToInt(Employee::getOld).sum();
        System.out.println(sum);

        System.out.println("--------------------------");
        final int[] arrays = employees.stream().mapToInt(Employee::getOld).toArray();
        System.out.println(Arrays.toString(arrays));

        System.out.println("--------------------------");
        final Stream<Integer> integerStream = employees.stream().mapToInt(Employee::getOld).boxed();
        System.out.println(integerStream);

        System.out.println("--------------------------");
        final IntSummaryStatistics integerStatistics = employees.stream().mapToInt(Employee::getOld).summaryStatistics();
        System.out.println(integerStatistics.getMin());
        System.out.println(integerStatistics.getMax());
        System.out.println(integerStatistics.getSum());
        System.out.println(integerStatistics.getAverage());
    }
}
