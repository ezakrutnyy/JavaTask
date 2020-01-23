package reportservice.generator;

import reportservice.specification.ReportSpecification;
import reportservice.strategy.ReportData;
import reportservice.strategy.ReportingDataAccumulation;
import reportservice.value.AeroflotTransaction;

public class TrxReportGenerator implements ReportGenerator {

    private final Generator<AeroflotTransaction> generator;

    public TrxReportGenerator(ReportingDataAccumulation<AeroflotTransaction> strategy,
                              ReportSpecification<AeroflotTransaction> specification,
                              Iterable<AeroflotTransaction> entities) {
        this.generator = new Generator<>(strategy, specification, entities);
    }

    @Override
    public ReportData generate() {
        return generator.generate();
    }

}