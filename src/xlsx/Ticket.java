package xlsx;

import java.math.BigDecimal;

public class Ticket {

    String number;

    Integer count;

    BigDecimal amount;

    String employee;

    public void setNumber(String number) {
        this.number = number;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public String getNumber() {
        return number;
    }

    public Integer getCount() {
        return count;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getEmployee() {
        return employee;
    }
}
