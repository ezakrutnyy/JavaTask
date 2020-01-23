package reportservice.specification.mappers;

import com.google.common.collect.Lists;

import java.util.List;

public class Mappers {

    public static <T> List<Object> map(List<ValueMapper<T>> mappers, T entity) {
        List<Object> values = Lists.newArrayList();

        for (ValueMapper<T> mapper : mappers) {
            Object value = mapper.map(entity);
            values.add(value);
        }

        return values;

    }

    public static <T> List<Object> map(List<ValueMapper<T>> mappers) {
        List<Object> values = Lists.newArrayList();

        for (ValueMapper<T> mapper : mappers) {
            Object value = mapper.map(null);
            values.add(value);
        }

        return values;
    }
}