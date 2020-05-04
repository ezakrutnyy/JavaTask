package serialization.externalizable;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.math.BigDecimal;

public class CarExternalizable implements Externalizable {

    private String marka;

    private String model;

    private BigDecimal price;

    public CarExternalizable(String marka, String model, BigDecimal price) {
        this.marka = marka;
        this.model = model;
        this.price = price;
    }

    public CarExternalizable() {
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(this.marka);
        out.writeObject(this.model);
        out.writeObject(this.price);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.marka = (String) in.readObject();
        this.model = (String) in.readObject();
        this.price = (BigDecimal) in.readObject();
    }

    @Override
    public String toString() {
        return "CarExternalizable{" +
                "marka='" + marka + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                '}';
    }
}
