package serializations.databind.fastjson;

import com.alibaba.fastjson.JSON;
import serializations.value.BankRates;
import serializations.value.CreatorRates;

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
