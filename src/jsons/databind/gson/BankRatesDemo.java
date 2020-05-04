package jsons.databind.gson;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import jsons.value.BankRates;
import jsons.value.CreatorRates;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

public class BankRatesDemo {
    public static void main(String[] args) {
        Type itemsMapType = new TypeToken<Map<Integer, BankRates>>() {}.getType();
        Type itemsListType = new TypeToken<List<BankRates>>() {}.getType();
        Type itemsArrType = new TypeToken<BankRates[]>() {}.getType();

        List<BankRates> rates = CreatorRates.fill();
        Gson gson = new Gson();

        String jsonStr = gson.toJson(rates);
        System.out.println("JSON:"+jsonStr);

        List<BankRates> newRates = gson.fromJson(jsonStr, itemsListType);
        System.out.println("OBJECT:"+newRates);
    }
}
