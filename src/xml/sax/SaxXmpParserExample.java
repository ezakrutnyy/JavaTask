package xml.sax;

import com.google.common.collect.Lists;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class SaxXmpParserExample {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        File file = new File("C:\\Users\\zakru\\IdeaProjects\\JavaTask\\resources\\xmls\\phone.xml");

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        List<String> numbers = Lists.newArrayList();
        DefaultHandler handler = new DefaultHandler(){

            boolean isNumber = false;

            @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                if (qName.equalsIgnoreCase("number")) isNumber = true;
                for (int i = 0; i < attributes.getLength(); i++) {
                    String name = attributes.getLocalName(i);
                    String value = attributes.getValue(i);
                    System.out.println(name + " : "+value);
                }
            }

            @Override
            public void characters(char[] ch, int start, int length) throws SAXException {
                if (isNumber) {
                    numbers.add(new String(ch, start, length));
                    isNumber = false;
                }

            }
        };
        parser.parse(file, handler);
        System.out.println("After:"+numbers);

    }
}
