package serializations.value;

import java.math.BigDecimal;
import java.util.Date;

public class TicketAirlineData {

    private String accountNumber;

    private String billingFileName;

    private Date billingFileDate;

    private String invoiceNumber;

    private BigDecimal ticketCost;

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getBillingFileName() {
        return billingFileName;
    }

    public void setBillingFileName(String billingFileName) {
        this.billingFileName = billingFileName;
    }

    public Date getBillingFileDate() {
        return billingFileDate;
    }

    public void setBillingFileDate(Date billingFileDate) {
        this.billingFileDate = billingFileDate;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public BigDecimal getTicketCost() {
        return ticketCost;
    }

    public void setTicketCost(BigDecimal ticketCost) {
        this.ticketCost = ticketCost;
    }
}
