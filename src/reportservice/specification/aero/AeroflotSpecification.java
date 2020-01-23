package reportservice.specification.aero;

import com.google.common.collect.Lists;
import reportservice.specification.ReportBlockSpecification;
import reportservice.specification.ReportSpecification;
import reportservice.specification.formatter.StringFormatter;
import reportservice.specification.mappers.ComputableMapper;
import reportservice.specification.mappers.ConstantMapper;
import reportservice.specification.mappers.ValueMapper;
import reportservice.value.AeroflotTransaction;

import java.util.List;

public class AeroflotSpecification {

    public ReportSpecification<AeroflotTransaction> getSpecification() {

        final ReportBlockSpecification<AeroflotTransaction> header = new ReportBlockSpecification<AeroflotTransaction>() {

            @Override
            public List<ValueMapper<AeroflotTransaction>> getMappers() {
                List<ValueMapper<AeroflotTransaction>> mappers = Lists.newArrayList();
                mappers.add(new ConstantMapper<>("ExternalID"));
                mappers.add(new ConstantMapper<>("TerminalID"));
                mappers.add(new ConstantMapper<>("MerchantID"));
                mappers.add(new ConstantMapper<>("TransactionDate"));
                mappers.add(new ConstantMapper<>("TransactionAmount"));
                return mappers;
            }

            @Override
            public boolean isStatic() {
                return true;
            }
        };

        final ReportBlockSpecification<AeroflotTransaction> body = new ReportBlockSpecification<AeroflotTransaction>() {

            @Override
            public List<ValueMapper<AeroflotTransaction>> getMappers() {
                List<ValueMapper<AeroflotTransaction>> mappers = Lists.newArrayList();
                mappers.add(new ComputableMapper<>(new StringFormatter(), AeroflotTransaction::getExtId));
                mappers.add(new ConstantMapper<>("TerminalID"));
                mappers.add(new ConstantMapper<>("MerchantID"));
                mappers.add(new ConstantMapper<>("TransactionDate"));
                mappers.add(new ConstantMapper<>("TransactionAmount"));
                return mappers;
            }

            @Override
            public boolean isStatic() {
                return false;
            }
        };

        return () -> Lists.newArrayList(header, body);
    }
}