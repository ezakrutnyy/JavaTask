package xml.stax;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class StaxPaser {
    public static void main(String[] args) throws FileNotFoundException, XMLStreamException {
        File file = new File("C:\\Users\\zakru\\IdeaProjects\\JavaTask\\resources\\xmls\\heroes.xml");
        XMLOutputFactory factory = XMLOutputFactory.newInstance();
        XMLStreamWriter writer = factory.createXMLStreamWriter(new FileOutputStream(file));

        writer.writeStartDocument();
        writer.writeStartElement("heroes");
            writer.writeStartElement("heroy");
                writer.writeStartElement("name");
                writer.writeCharacters("Batman");
                writer.writeEndElement();
                writer.writeStartElement("skill");
                writer.writeCharacters("Fly");
                writer.writeEndElement();
            writer.writeEndElement();
            writer.writeStartElement("heroy");
                writer.writeStartElement("name");
                writer.writeCharacters("Tor");
                writer.writeEndElement();
                writer.writeStartElement("skill");
                writer.writeCharacters("Hit");
                writer.writeEndElement();
            writer.writeEndElement();
        writer.writeEndElement();
        writer.writeEndDocument();

    }
}
