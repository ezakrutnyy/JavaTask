package collections.set;

import java.util.HashSet;
import java.util.Objects;

public class HashSetDemo {
    public static void main(String[] args) {
        HashSet<Elem> set = new HashSet<>();
        set.add(new Elem("aaa"));
        set.add(new Elem("bbb"));
        set.add(new Elem("ccc"));
        set.add(new Elem("aaa"));
        System.out.println(set);
    }
}

class Elem {

    String st;

    public Elem(String st) {
        this.st = st;
    }

    public String getSt() {
        return st;
    }

    public void setSt(String st) {
        this.st = st;
    }

    @Override
    public String toString() {
        return "Elem{" +
                "st='" + st + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Elem elem = (Elem) o;
        return Objects.equals(st, elem.st);
    }

    @Override
    public int hashCode() {
        return Objects.hash(st);
    }
}
