package serializations.treemodel.jackson;

import serializations.value.BankRates;
import serializations.value.CreatorRates;
import java.util.List;

public class BankRatesDemo {
    public static void main(String[] args) {

        List<BankRates> rates = CreatorRates.fill();

        String json = BankRatesJsonParser.ratesToJson(rates);
        System.out.println("JSON:"+json);

        List<BankRates> newRates = BankRatesJsonParser.jsonToRate(json);

        System.out.println("OBJECT:"+newRates);

    }
}
