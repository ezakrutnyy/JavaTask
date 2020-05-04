package xml;

import java.math.BigDecimal;

public class Currency {

    private String code;

    private String shortName;

    private String name;

    private BigDecimal value;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "code='" + code + '\'' +
                ", shortName='" + shortName + '\'' +
                ", name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
