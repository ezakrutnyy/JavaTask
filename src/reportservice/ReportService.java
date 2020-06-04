package reportservice;

import com.google.common.collect.Lists;
import reportservice.generator.TrxReportGenerator;
import reportservice.specification.aero.AeroflotSpecification;
import reportservice.strategy.PlainTextAccumulationStrategy;
import reportservice.value.AeroflotTransaction;

import java.math.BigDecimal;
import java.nio.file.Path;
import java.util.Date;
import java.util.List;

public class ReportService {

    public static void main(String[] args) {


        System.out.println(String.format("%08d", Integer.parseInt("3232")));

        List<AeroflotTransaction> transactions = fill();
        AeroflotSpecification specification = new AeroflotSpecification();
        PlainTextAccumulationStrategy<AeroflotTransaction> strategy = new PlainTextAccumulationStrategy<>();
        TrxReportGenerator generator = new TrxReportGenerator(strategy, specification.getSpecification(), transactions);
        Path path = generator.generate().asFilePath("report.txt");
        System.out.println(path);
    }

    private static List<AeroflotTransaction> fill() {
        List<AeroflotTransaction> transactions = Lists.newArrayList();
        AeroflotTransaction transaction1 = new AeroflotTransaction();
        transaction1.setExtId("10000001");
        transaction1.setMid("999901");
        transaction1.setTid("99999901");
        transaction1.setTransactionAmount(new BigDecimal(1000));
        transaction1.setTransactionDate(new Date());
        transactions.add(transaction1);
        AeroflotTransaction transaction2 = new AeroflotTransaction();
        transaction2.setExtId("10000002");
        transaction2.setMid("999902");
        transaction2.setTid("99999902");
        transaction2.setTransactionAmount(new BigDecimal(750));
        transaction2.setTransactionDate(new Date());
        transactions.add(transaction2);
        AeroflotTransaction transaction3 = new AeroflotTransaction();
        transaction3.setExtId("10000003");
        transaction3.setMid("999903");
        transaction3.setTid("99999903");
        transaction3.setTransactionAmount(new BigDecimal(27950));
        transaction3.setTransactionDate(new Date());
        transactions.add(transaction3);
        return transactions;
    }
}
