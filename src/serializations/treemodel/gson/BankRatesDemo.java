package serializations.treemodel.gson;

import com.google.gson.*;
import serializations.value.BankRates;
import serializations.value.CreatorRates;

import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;


public class BankRatesDemo {

//    public static void main(String[] args) throws IOException {
//
//        List<BankRates> rates = CreatorRates.fill();
//
//        String json = writeJson(rates);
//        System.out.println("JSON:"+json);
//
//        List<BankRates> newRates = readJson(json);
//        System.out.println("OBJECT:"+newRates);
//    }
//
//
//
//
//    private static String writeJson(List<BankRates> rates) throws IOException {
//        JsonArray newRates = new JsonArray();
//        rates.stream().forEach(rate -> {
//            JsonObject rootObject = new JsonObject();
//            rootObject.addProperty("bankName", rate.getBankName());
//
//            JsonArray newRate = new JsonArray();
//            rate.getRates().stream().forEach( rt -> {
//                JsonObject childObject = new JsonObject();
//                childObject.addProperty("type", rt.getType());
//                childObject.addProperty("rate", rt.getRate());
//                newRate.add(childObject);
//
//            });
//            rootObject.add("rates", newRate);
//
//            newRates.add(rootObject);
//        });
//
//        Gson gson = new Gson();
//        String json = gson.toJson(newRates);
//        return json;
//    }
//
//    private static List<BankRates> readJson(String json) throws IOException {
//        JsonParser parser = new JsonParser();
//        JsonElement jsonElement  = parser.parse(json);
//
//    }
//
//
//}
//
// class CustomConverter implements JsonSerializer<BankRates>, JsonDeserializer<BankRates>  {
//    public JsonElement serialize(BankRates src, Type type,
//                                 JsonSerializationContext context) {
//        JsonObject object = new JsonObject();
//        object.addProperty("date", src.date.getTime());
//        object.addProperty("integer", src.integer.toString());
//        return object;
//    }
//
//    public BankRates deserialize(JsonElement json, Type type,
//                              JsonDeserializationContext context) throws JsonParseException {
//        JsonObject object = json.getAsJsonObject();
//        Date date = new Date(object.get("date").getAsLong());
//        BigInteger integer = new BigInteger(object.get("integer").getAsString());
//        return new Custom(date, integer);
//    }
}
