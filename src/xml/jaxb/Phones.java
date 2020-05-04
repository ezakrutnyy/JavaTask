package xml.jaxb;

import com.google.common.collect.Lists;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "phones")
public class Phones {

    @XmlElement(name = "phone")
    List<Phone> phones = Lists.newArrayList();

    public void add(Phone phone) {
        phones.add(phone);
    }

    @Override
    public String toString() {
        return "Phones{" +
                "phones=" + phones +
                '}';
    }
}
