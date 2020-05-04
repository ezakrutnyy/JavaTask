package jsons.value;

import java.math.BigDecimal;

public class Rate {

    private String type;

    private BigDecimal rate;

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Rate{" +
                "type='" + type + '\'' +
                ", rate=" + rate +
                '}';
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }
}
