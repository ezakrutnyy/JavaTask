package serialization.externalizable;

import java.io.*;
import java.math.BigDecimal;
import java.util.List;

public class CarDemoSerialization {
    public static void main(String[] args) {

        final File file = new File("C:\\Users\\zakru\\IdeaProjects\\JavaTask\\resources\\serialization\\cars.txt");

        CarExternalizable carExternalizable = new CarExternalizable("Skoda", "Rapid", new BigDecimal(300000));

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(carExternalizable);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            CarExternalizable carExternalizableNew = (CarExternalizable) ois.readObject();
            System.out.println(carExternalizableNew);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
