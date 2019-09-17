package json;

import com.google.common.collect.Lists;

import java.math.BigDecimal;
import java.util.List;

public class BankRatesDemo {
    public static void main(String[] args) {

        List<BankRates> banks = Lists.newArrayList();

        BankRates bank = new BankRates();
        bank.setBankName("SberBank");

        List<Rate> rates = Lists.newArrayList();

        Rate rate = new Rate();
        rate.setType("AUTO");
        rate.setRate(new BigDecimal(7.99));
        rates.add(rate);

        rate = new Rate();
        rate.setType("IPOTEKA");
        rate.setRate(new BigDecimal(6.99));
        rates.add(rate);

        bank.setRates(rates);

        banks.add(bank);

        bank = new BankRates();
        bank.setBankName("Vtb");

        rates = Lists.newArrayList();

        rate = new Rate();
        rate.setType("POTREB");
        rate.setRate(new BigDecimal(14.34));
        rates.add(rate);

        bank.setRates(rates);

        banks.add(bank);


        String json = BankRatesJsonParser.ratesToJson(banks);
        System.out.println("JSON:"+json);

        List<BankRates> newBanks = BankRatesJsonParser.jsonToRate(json);

        System.out.println("NewBanks:"+newBanks);

    }
}
