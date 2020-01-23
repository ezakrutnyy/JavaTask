package reportservice.specification.formatter;

public interface ValueFormatter {

    String format(Object value);

    int width();
}