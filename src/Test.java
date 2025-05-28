import java.io.IOException;
import java.time.Instant;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Date;

public class Test {
    public static void main(String[] args) throws IOException {
        ZonedDateTime zonedDateTime = Instant.now().atOffset(ZoneOffset.of("-04:00")).toZonedDateTime();
        System.out.println(zonedDateTime);
        System.out.println(zonedDateTime.toLocalDate());
        System.out.println(zonedDateTime.toEpochSecond());
        System.out.println(new Date(zonedDateTime.toEpochSecond()));
    }
}