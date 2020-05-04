package jsons.treemodel.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.google.common.base.Splitter;
import jsons.value.BankRates;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class BankRatesJsonParser {

    public static String ratesToJson(List<BankRates> rates) {
        ObjectMapper mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addSerializer(BankRates.class, new BankRatesSerializer());
        mapper.registerModule(module);

        return rates.stream().map(bankRate -> {
            try {
                return mapper.writeValueAsString(bankRate);
            } catch (JsonProcessingException ex) {
                throw new RuntimeException("Error while serialization!");
            }
        }).collect(Collectors.joining(";"));
    }


    public static  List<BankRates> jsonToRate(String json) {
        ObjectMapper mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addDeserializer(BankRates.class, new BankRatesDeserializer());
        mapper.registerModule(module);

        return Splitter.on(";").splitToList(json).stream().map(rate -> {
            try {
                return mapper.readValue(rate, BankRates.class);
            } catch (IOException e) {
                throw new RuntimeException("Error while deserialization!");
            }
        }).collect(Collectors.toList());
    }
}
