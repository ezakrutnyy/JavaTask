package serialization.serializable;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Home extends AbstractHome implements Serializable {

    public static int count = 0;


    public Home(String foundament, Fabric fabric, int floor, int rooms) {
        super(rooms);
        this.foundament = foundament;
        this.fabric = fabric;
        this.floor = floor;
    }

    private static final long serialVersionUID = 4280288540266252796L;



    private String foundament;

    private Fabric fabric;

    private transient int floor;

    public void setFoundament(String foundament) {
        this.foundament = foundament;
    }

    public Fabric getFabric() {
        return fabric;
    }

    public String getFoundament() {
        return foundament;
    }

    public void setFabric(Fabric fabric) {
        this.fabric = fabric;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    @Override
    public String toString() {
        return super.toString() +"Home{" +
                "foundament='" + foundament + '\'' +
                ", fabric=" + fabric +
                ", floor=" + floor +
                '}';
    }

    // Явное описание transient полей

    private void writeObject(ObjectOutputStream oos) {
        // запишем то что можем записать
        try {
            oos.defaultWriteObject();
            oos.writeInt(this.floor);
            oos.writeInt(count);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readObject(ObjectInputStream ois) {
        // запишем то что можем записать
        try {
            // прочитаем что можем
            ois.defaultReadObject();
            this.floor = ois.readInt();
            count = ois.readInt();
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}
