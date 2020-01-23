package reportservice.specification.formatter;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class StringFormatter extends AbstractValueFormatter {

    private final static int UNLIMITED_WIDTH = 0;

    private Padding padding;

    public StringFormatter(int width) {
        this(width, Padding.LEFT);
    }

    public StringFormatter(int width, Padding padding) {
        super(width);
        this.padding = padding;
    }

    public StringFormatter() {
        super(UNLIMITED_WIDTH);
    }

    @Override
    public String format(Object value) {

        if (Objects.isNull(value))
            return StringUtils.EMPTY;

        if (width() == UNLIMITED_WIDTH)
            return String.valueOf(value);

        String pattern = "%" + (padding.equals(Padding.LEFT) ? "-" : "") + width() + "s";
        return String.format(pattern, value);
    }

    public enum Padding {
        LEFT,
        RIGHT
    }
}