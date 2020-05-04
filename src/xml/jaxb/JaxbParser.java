package xml.jaxb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class JaxbParser {
    public static void main(String[] args) throws JAXBException {
        Phones phones = new Phones();
        phones.add(new Phone("Margo Hitch", "8-7678-273-22-09"));
        phones.add(new Phone("Samuel Eto", "4534-2323-21323"));

        File file = new File("C:\\Users\\zakru\\IdeaProjects\\JavaTask\\resources\\xmls\\phone_jaxb.xml");

        JAXBContext context = JAXBContext.newInstance(Phones.class);
        Marshaller marshaller = context.createMarshaller();

        // читабельность
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        // запись в файл
        marshaller.marshal(phones, file);

        // считываем из файла
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Phones phonesCopy = (Phones) unmarshaller.unmarshal(file);
        System.out.println(phonesCopy);
    }
}
