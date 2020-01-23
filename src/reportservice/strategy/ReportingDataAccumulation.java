package reportservice.strategy;


import reportservice.specification.ReportBlockSpecification;

public interface ReportingDataAccumulation<T> {

    void add(ReportBlockSpecification<T> block);

    void add(ReportBlockSpecification<T> block, T entity);

    ReportData get();

}