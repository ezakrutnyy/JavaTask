package objects;

import com.google.common.collect.Maps;

import java.util.Map;
import java.util.Objects;

public class EqualsAndHashCodeOverride {
    public static void main(String[] args) {

        Map<Key, String> maps = Maps.newHashMap();

        Key key1 = new Key("1111","2222");
        Key key2 = new Key("3333","4444");
        Key key3 = new Key("1111","2222");
        Key key4 = new Key("5555","2222");

        maps.put(key1, "String 1");
        maps.put(key2, "String 2");
        maps.put(key3, "String 3");
        maps.put(key4, "String 4");

        System.out.println(maps.get(key1));
        System.out.println(maps.get(key2));
        System.out.println(maps.get(key3));
        System.out.println(maps.get(key4));

    }

}

class Key {

    private final String serial1;

    private final String serial2;

    public Key(String serial1, String serial2) {
        this.serial1 = serial1;
        this.serial2 = serial2;
    }

    public String getSerial1() {
        return serial1;
    }

    public String getSerial2() {
        return serial2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Key key = (Key) o;
        return Objects.equals(serial1, key.serial1) && Objects.equals(serial2, key.serial2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serial1, serial2);
    }

    @Override
    public String toString() {
        return "Key{" +
                "serial1='" + serial1 + '\'' +
                ", serial2='" + serial2 + '\'' +
                '}';
    }
}
