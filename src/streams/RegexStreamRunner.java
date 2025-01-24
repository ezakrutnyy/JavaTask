package streams;

import java.util.regex.Pattern;
import java.util.stream.Stream;

public class RegexStreamRunner {
    public static void main(String[] args) {
        final Pattern pattern = Pattern.compile(".*one.*");
        final Stream<String> streams = Stream.of("Stone", "one", "two", "London", "clones");
        System.out.println("--------pattern.asPredicate()--------------");
        streams.filter(pattern.asPredicate()).forEach(System.out::println);
    }
}