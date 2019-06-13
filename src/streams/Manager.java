package streams;

import java.math.BigDecimal;

public class Manager extends Employee {
    private BigDecimal salary;

    public Manager(String name, String city, Integer old, BigDecimal salary) {
        super(name, city, old);
        this.salary = salary;
    }
}
