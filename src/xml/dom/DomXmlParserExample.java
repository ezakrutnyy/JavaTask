package xml.dom;

import com.google.common.collect.Lists;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import xml.Currency;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.util.List;

public class DomXmlParserExample {

    private static final String pattern = "#,##0.00";
    private static final DecimalFormatSymbols symbols = new DecimalFormatSymbols();
    static {
        symbols.setDecimalSeparator(',');
    }

    // Document, Element, Attribute, Text

    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException, ParseException, TransformerException {
        URL url = new URL("https://www.cbr-xml-daily.ru/daily.xml");
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = dbf.newDocumentBuilder();
        Document doc = builder.parse(url.openStream());
        Element root = doc.getDocumentElement();

        NodeList nodes = root.getChildNodes();
//        for (int i = 0; i < nodes.getLength(); i++) {
//            Node node = nodes.item(i);
//            if (node.getNodeType() == Node.ELEMENT_NODE) {
//                String code = node.getChildNodes().item(0).getChildNodes().item(0).getNodeValue();
//                String shortName = node.getChildNodes().item(1).getChildNodes().item(0).getNodeValue();
//                String name = node.getChildNodes().item(2).getChildNodes().item(0).getNodeValue();
//                String value = node.getChildNodes().item(4).getChildNodes().item(0).getNodeValue();
//                System.out.println(code);
//                System.out.println(shortName);
//                System.out.println(name);
//                System.out.println(value);
//                System.out.println("-----------------------------------");
//            }
//        }

        final List<Currency> currencies = Lists.newArrayList();

        // 2 способ
        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                Currency currency = new Currency();
                currency.setCode(element.getElementsByTagName("NumCode").item(0).getChildNodes().item(0).getNodeValue());
                currency.setShortName(element.getElementsByTagName("CharCode").item(0).getChildNodes().item(0).getNodeValue());
                currency.setName(element.getElementsByTagName("Name").item(0).getChildNodes().item(0).getNodeValue());

                DecimalFormat decimalFormat = new DecimalFormat(pattern, symbols);
                decimalFormat.setParseBigDecimal(true);
                String valueStr = element.getElementsByTagName("Value").item(0).getChildNodes().item(0).getNodeValue();
                BigDecimal value = (BigDecimal) decimalFormat.parse(valueStr);
                currency.setValue(value);
                currencies.add(currency);
            }
        }

        // Запишем в файл
        File file = new File("C:\\Users\\zakru\\IdeaProjects\\JavaTask\\resources\\xmls\\currency.xml");
        Document docNew = builder.newDocument();
        // Currencies
        Element currenciesElement = docNew.createElement("Currencies");
        docNew.appendChild(currenciesElement);

        for (Currency currency : currencies) {
            // Currency
            Element currencyElementNew = docNew.createElement("Currency");
            currenciesElement.appendChild(currencyElementNew);

            Element codeCurrencyElement = docNew.createElement("Code");
            codeCurrencyElement.setTextContent(currency.getCode());

            Element valueCurrencyElement = docNew.createElement("Value");
            valueCurrencyElement.setTextContent(currency.getValue().toString());

            currencyElementNew.appendChild(codeCurrencyElement);
            currencyElementNew.appendChild(valueCurrencyElement);
        }

        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer t = tf.newTransformer();
        DOMSource source = new DOMSource(docNew);
        StreamResult stream = new StreamResult(file);
        t.transform(source, stream);
    }
}