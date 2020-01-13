package serializations.treemodel.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.collect.Lists;
import serializations.value.TicketAirlineData;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class JacksonTree {

    public static String writeJson(List<TicketAirlineData> tickets) {
        ObjectMapper mapper = new ObjectMapper();
        ArrayNode nodes = mapper.createArrayNode();
        for (TicketAirlineData ticket : tickets) {
            ObjectNode node = mapper.createObjectNode();
            node.put("AccountNumber", ticket.getAccountNumber());
            node.put("BillingFileName", ticket.getBillingFileName());
            node.put("BillingFileDate", ticket.getBillingFileDate().getTime());
            node.put("InvoiceNumber", ticket.getInvoiceNumber());
            node.put("TicketCost", ticket.getTicketCost());
            nodes.add(node);
        }
        try {
            return mapper.writeValueAsString(nodes);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static List<TicketAirlineData> readJson(String json) {
        ObjectMapper mapper = new ObjectMapper();
        List<TicketAirlineData> result = Lists.newArrayList();
        try {
            ArrayNode nodes = mapper.readValue(json, ArrayNode.class);
            for (JsonNode node : nodes) {
                TicketAirlineData ticket = new TicketAirlineData();
                ticket.setAccountNumber(node.get("AccountNumber").asText());
                ticket.setBillingFileName(node.get("BillingFileName").asText());
                ticket.setBillingFileDate(new Date(node.get("BillingFileDate").asLong()));
                ticket.setInvoiceNumber(node.get("InvoiceNumber").asText());
                ticket.setTicketCost(BigDecimal.valueOf(node.get("TicketCost").asDouble()));
                result.add(ticket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

}