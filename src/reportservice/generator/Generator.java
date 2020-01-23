package reportservice.generator;

import reportservice.specification.ReportBlockSpecification;
import reportservice.specification.ReportSpecification;
import reportservice.strategy.ReportData;
import reportservice.strategy.ReportingDataAccumulation;

import java.util.List;

public class Generator<T> {

    private ReportingDataAccumulation<T> strategy;

    private ReportSpecification<T> specification;

    private Iterable<T> entities;

    public Generator(ReportingDataAccumulation<T> strategy, ReportSpecification<T> specification, Iterable<T> entities) {
        this.strategy = strategy;
        this.specification = specification;
        this.entities = entities;
    }

    public ReportData generate() {
        List<ReportBlockSpecification<T>> blocks = specification.getBlocks();
        for (ReportBlockSpecification<T> block : blocks) {
            if (block.isStatic()) {
                strategy.add(block);
            } else {
                for (T entity : entities)
                    strategy.add(block, entity);
            }
        }
        return strategy.get();
    }
}