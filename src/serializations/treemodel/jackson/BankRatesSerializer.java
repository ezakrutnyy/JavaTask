package serializations.treemodel.jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import serializations.value.BankRates;
import serializations.value.Rate;

import java.io.IOException;

public class BankRatesSerializer extends StdSerializer<BankRates> {

    BankRatesSerializer() {
        this(null);

    }

    private BankRatesSerializer(Class<BankRates> t) {
        super(t);
    }

    @Override
    public void serialize(BankRates bankRates, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();

            jsonGenerator.writeObjectField("BankName", bankRates.getBankName());

            jsonGenerator.writeArrayFieldStart("Rates");

            for (Rate rate : bankRates.getRates()) {
                jsonGenerator.writeStartObject();
                    jsonGenerator.writeObjectField("Type", rate.getType());
                    jsonGenerator.writeObjectField("Rate", rate.getRate());
                jsonGenerator.writeEndObject();
            }
            jsonGenerator.writeEndArray();

        jsonGenerator.writeEndObject();

    }
}
