package xml.jaxb;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = { "name", "number" }, name = "phone")
@XmlRootElement(name = "phone")
public class Phone {

    String name;

    String number;

    public Phone(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public Phone() {
    }

    @Override
    public String toString() {
        return "Phone{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    @XmlElement
    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    @XmlElement
    public void setNumber(String number) {
        this.number = number;
    }
}
