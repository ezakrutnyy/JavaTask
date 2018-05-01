package objects.blockinit;

import java.util.Random;

/**
 * Created by Евгений on 29.10.2017.
 */
public class BlockInitDemo {
    public static void main(String[] args) {

        String[] names = { "Carl Cracker", "Harry Hacker", "Tony Tester" };
        InitEmployee[] staff = new InitEmployee[3];

        for (int i = 0; i < 3; i++) {

            staff[i] = new InitEmployee();
            staff[i].setName(names[i]);
        }

        for (InitEmployee e : staff) {
            System.out.println("name=" + e.getName() + ",id=" + e.getId());
        }
    }

}

class InitEmployee {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    private static int nextId;
    private int id;
    private String name;

    static {
        Random generator = new Random();
        nextId = generator.nextInt(10);
    }

    {
        id = nextId;
        nextId++;
    }
}
