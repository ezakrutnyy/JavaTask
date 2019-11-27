package serializations.databind.genson;

import com.owlike.genson.GenericType;
import com.owlike.genson.Genson;
import serializations.value.BankRates;
import serializations.value.CreatorRates;

import java.util.List;

public class BankRatesDemo {

    public static void main(String[] args) {
        Genson genson = new Genson();

        List<BankRates> rates = CreatorRates.fill();
        String json = genson.serialize(rates);
        System.out.println("JSON:"+json);

        List<BankRates> newRates = genson.deserialize(json, new GenericType<List<BankRates>>(){});
        System.out.println("OBJECT:"+newRates);

    }
}
