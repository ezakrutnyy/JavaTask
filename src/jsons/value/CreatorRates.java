package jsons.value;

import com.google.common.collect.Lists;

import java.math.BigDecimal;
import java.util.List;

public class CreatorRates {

    public static List<BankRates> fill() {

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

        return banks;

    }
}
