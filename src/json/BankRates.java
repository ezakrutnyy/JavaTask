package json;

import java.util.List;

public class BankRates {

    private String bankName;

    private List<Rate> rates;

    public List<Rate> getRates() {
        return rates;
    }

    @Override
    public String toString() {
        return "BankRates{" +
                "bankName='" + bankName + '\'' +
                ", rates=" + rates +
                '}';
    }

    public void setRates(List<Rate> rates) {
        this.rates = rates;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
}
