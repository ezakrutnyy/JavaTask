package serializations.treemodel.gson;

import com.google.common.collect.Lists;
import com.google.gson.*;
import serializations.value.TicketAirlineData;

import java.util.Date;
import java.util.List;

public class GsonTree {

    public static String writeJson(List<TicketAirlineData> tickets) {
        JsonArray inputData = new JsonArray();
        for (TicketAirlineData ticket : tickets) {
            JsonObject root = new JsonObject();
            root.addProperty("AccountNumber", ticket.getAccountNumber());
            root.addProperty("BillingFileName", ticket.getBillingFileName());
            root.addProperty("BillingFileDate", ticket.getBillingFileDate().getTime());
            root.addProperty("InvoiceNumber", ticket.getInvoiceNumber());
            root.addProperty("TicketCost", ticket.getTicketCost());
            inputData.add(root);
        }
        return new Gson().toJson(inputData);
    }

    public static List<TicketAirlineData> readJson(String json) {
        JsonParser parser = new JsonParser();
        JsonElement elem = parser.parse(json);
        JsonArray ticketsJson = elem.getAsJsonArray();
        List<TicketAirlineData> result = Lists.newArrayList();
        for (JsonElement ticketJson : ticketsJson) {
            JsonObject object = ticketJson.getAsJsonObject();
            TicketAirlineData ticket = new TicketAirlineData();
            ticket.setAccountNumber(object.get("AccountNumber").getAsString());
            ticket.setBillingFileName(object.get("BillingFileName").getAsString());
            ticket.setBillingFileDate(new Date(object.get("BillingFileDate").getAsLong()));
            ticket.setInvoiceNumber(object.get("InvoiceNumber").getAsString());
            ticket.setTicketCost(object.get("TicketCost").getAsBigDecimal());
            result.add(ticket);
        }
        return result;
    }
}