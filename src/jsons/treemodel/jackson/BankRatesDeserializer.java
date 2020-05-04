package jsons.treemodel.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.google.common.collect.Lists;
import jsons.value.BankRates;
import jsons.value.Rate;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class BankRatesDeserializer extends StdDeserializer<BankRates> {

    BankRatesDeserializer() {
        this(null);

    }

    private BankRatesDeserializer(Class<BankRates> t) {
        super(t);
    }

    @Override
    public BankRates deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        JsonNode root = jsonParser.getCodec().readTree(jsonParser);
        BankRates bank = new BankRates();
        String bankName = root.get("BankName").asText();
        bank.setBankName(bankName);
        List<Rate> rates = Lists.newArrayList();
        for (JsonNode node : root.get("Rates")) {
            String type = node.get("Type").asText();
            BigDecimal amount = new BigDecimal(node.get("Rate").asText()).setScale(2, RoundingMode.HALF_UP);
            Rate rate = new Rate();
            rate.setType(type);
            rate.setRate(amount);
            rates.add(rate);
        }
        bank.setRates(rates);
        return bank;
    }
}
