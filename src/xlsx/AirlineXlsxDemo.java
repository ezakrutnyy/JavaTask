package xlsx;

import com.google.common.collect.Lists;
import org.jxls.common.Context;
import org.jxls.util.JxlsHelper;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class AirlineXlsxDemo {

    private static final Path templatePath = Paths.get("resources/xlsx/airline.xlsx");

    private static final Path templateOutputPath = Paths.get("resources/xlsx/airline_result.xlsx");

    private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

    public static void main(String[] args) throws IOException {

        final List<Ticket> tickets = getTickets();

        try (InputStream is = Files.newInputStream(templatePath)) {
            try (OutputStream os = Files.newOutputStream(templateOutputPath)) {
                Context context = new Context();
                context.putVar("currentDate", dateFormat.format(new Date()));
                context.putVar("tickets", tickets);
                JxlsHelper.getInstance().processTemplate(is, os, context);
            }
        }
    }

    private static List<Ticket> getTickets() {

        List<Ticket> tickets = Lists.newArrayList();

        final Ticket ticket = new Ticket();
        ticket.setEmployee("Иванов И.И");
        ticket.setCount(1);
        ticket.setAmount(new BigDecimal(1760.00));
        ticket.setNumber("1000898101");
        tickets.add(ticket);

        final Ticket ticket2 = new Ticket();
        ticket2.setEmployee("Петрова К.М");
        ticket2.setCount(1);
        ticket2.setAmount(new BigDecimal(999.00));
        ticket2.setNumber("1000898102");
        tickets.add(ticket2);

        final Ticket ticket3 = new Ticket();
        ticket3.setEmployee("Сидоров Р.Р");
        ticket3.setCount(3);
        ticket3.setAmount(new BigDecimal(8900.00));
        ticket3.setNumber("1000898103");
        tickets.add(ticket3);

        return tickets;
    }
}
