package reportservice.specification;


import reportservice.specification.mappers.ValueMapper;

import java.util.List;

public interface ReportBlockSpecification<T> {

    List<ValueMapper<T>> getMappers();

    boolean isStatic();
}