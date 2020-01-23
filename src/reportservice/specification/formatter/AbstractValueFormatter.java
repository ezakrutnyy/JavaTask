package reportservice.specification.formatter;

abstract public class AbstractValueFormatter implements ValueFormatter {

    private int width;

    AbstractValueFormatter(int width) {
        this.width = width;
    }

    abstract public String format(Object value);

    @Override
    public int width() {
        return width;
    }
}