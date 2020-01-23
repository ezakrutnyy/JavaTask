package reportservice.specification.mappers;

import reportservice.specification.formatter.ValueFormatter;

import java.util.function.Function;

public class ComputableMapper<T> extends AbstractMapper<T> {

    private Function<T, ?> executorFunction;

    public ComputableMapper(ValueFormatter formatter, Function<T, ?> executorFunction) {
        super(formatter);
        this.executorFunction = executorFunction;
    }

    @Override
    public Object map(T object) {
        return valueFormatter().format(executorFunction.apply(object));
    }
}