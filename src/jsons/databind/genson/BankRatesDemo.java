package jsons.databind.genson;

import com.owlike.genson.GenericType;
import com.owlike.genson.Genson;
import jsons.value.BankRates;
import jsons.value.CreatorRates;

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
