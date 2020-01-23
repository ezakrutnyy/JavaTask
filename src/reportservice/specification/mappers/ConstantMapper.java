package reportservice.specification.mappers;


import reportservice.specification.formatter.StringFormatter;
import reportservice.specification.formatter.ValueFormatter;

public class ConstantMapper<T> extends AbstractMapper<T> {

    private Object value;

    public ConstantMapper(String value, ValueFormatter formatter) {
        super(formatter);
        this.value = value;
    }

    public ConstantMapper(String value) {
        super(new StringFormatter(value.length()));
        this.value = value;
    }

    @Override
    public Object map(T object) {
        return valueFormatter().format(value);
    }
}