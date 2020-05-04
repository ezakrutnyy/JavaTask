package serialization.serializable;

public class AbstractHome {

    public AbstractHome() {
    }

    public AbstractHome(int rooms) {
        this.rooms = rooms;
    }

    private int rooms;

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    @Override
    public String toString() {
        return "AbstractHome{" +
                "rooms=" + rooms +
                '}';
    }
}
