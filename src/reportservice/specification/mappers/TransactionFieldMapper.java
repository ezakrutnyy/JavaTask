package reportservice.specification.mappers;

import reportservice.specification.formatter.ValueFormatter;
import reportservice.value.AeroflotTransaction;

public class TransactionFieldMapper extends AbstractMapper<AeroflotTransaction> {

    private String fieldName;

    public TransactionFieldMapper(ValueFormatter formatter, String fieldName) {
        super(formatter);
        this.fieldName = fieldName;
    }

    @Override
    public Object map(AeroflotTransaction object) {
        //Object fieldValue = object.getField
        Object fieldValue = "";
        return valueFormatter().format(fieldValue);
    }
}