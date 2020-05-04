package serialization.serializable;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class HomeSerializableDemo {

    public static void main(String[] args) {

        final File file = new File("C:\\Users\\zakru\\IdeaProjects\\JavaTask\\resources\\serialization\\homes.txt");

        List<Home> city = new ArrayList<>();

        Fabric treeFabric = new Fabric();
        treeFabric.setMaterial("Glued Beam");

        Fabric brickFabric = new Fabric();
        brickFabric.setMaterial("Brick");

        Home treeHome = new Home("Ribbon", treeFabric, 2, 6);

        Home brickHome = new Home("Brick", brickFabric, 6, 2);
        brickHome.setRooms(2);

        city.add(treeHome);
        city.add(brickHome);

        Home.count = 10;

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(city);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Home.count = 30;
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            List<Home> cities = (List<Home>) ois.readObject();
            System.out.println(cities);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("Home.count = " + Home.count);
    }
}
