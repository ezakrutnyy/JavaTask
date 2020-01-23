package reportservice.specification.mappers;

import reportservice.specification.formatter.ValueFormatter;

public interface ValueMapper<T> {

    ValueFormatter valueFormatter();

    Object map(T object);

}