package serializations.databind.jackson;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import serializations.value.BankRates;
import serializations.value.CreatorRates;

import java.io.IOException;
import java.util.List;

public class BankRatesDemo {
    public static void main(String[] args) throws IOException {

        List<BankRates> rates = CreatorRates.fill();

        TypeReference itemsListType = new TypeReference<List<BankRates>>(){};

        // convert to json
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(rates);
        System.out.println("JSON:"+jsonString);

        // convert from json
        List<BankRates> newRates =  mapper.readValue(jsonString, itemsListType);
        System.out.println("OBJECT:"+newRates);
    }
}
