package reportservice.specification;

import java.util.List;

public interface ReportSpecification<T> {

    List<ReportBlockSpecification<T>> getBlocks();
}
