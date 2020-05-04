package jsons.databind.fastjson;

import com.alibaba.fastjson.JSON;
import jsons.value.BankRates;
import jsons.value.CreatorRates;

import java.util.List;

public class BankRatesDemo {
    public static void main(String[] args) {
        List<BankRates> rates = CreatorRates.fill();
        String json = JSON.toJSONString(rates);
        System.out.println("JSON:"+json);
        List<BankRates> newRates = JSON.parseArray(json, BankRates.class);
        System.out.println("OBJECTS:"+newRates);

    }
}
