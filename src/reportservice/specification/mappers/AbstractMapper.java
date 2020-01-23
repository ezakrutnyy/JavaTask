package reportservice.specification.mappers;


import reportservice.specification.formatter.ValueFormatter;

abstract class AbstractMapper<T> implements ValueMapper<T> {

    private ValueFormatter formatter;

    public AbstractMapper(ValueFormatter formatter) {
        this.formatter = formatter;
    }

    @Override
    public ValueFormatter valueFormatter() {
        return formatter;
    }

    @Override
    abstract public Object map(T object);
}