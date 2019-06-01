package collections;

import java.time.Period;
import java.util.*;

/**
 * Created by Евгений on 06.05.2018.
 */
public class IterationsClass {
    public static void main(String[] args) {
        List<Pets> list = new ArrayList<Pets>();
        list.add(new Pets("Corney", 12));
        list.add(new Pets("Max", 3));
        list.add(new Pets("Tory", 5));
        list.add(new Pets("Sarah", 9));
        list.add(new Pets("Monkey", 3));

        System.out.println("Sorting by year...");
        Collections.sort(list);
        Iterator<Pets> iter = list.iterator();
        while(iter.hasNext()) {
            System.out.println(iter.next());
        }

        System.out.println("\nSorting by name...");

        Collections.sort(list,new PetsNameComparator());


        ListIterator<Pets> iter2 = list.listIterator(3);
        while(iter2.hasPrevious()) {
            System.out.println(iter2.previous());
        }


    }

    private static class PetsNameComparator implements Comparator<Pets> {

        public int compare(Pets o1, Pets o2) {
            String name1 = o1.getName();
            String name2 = o2.getName();
            return  name1.compareTo(name2);
        }
    }


    private static class Pets implements  Comparable {
        private String name;
        private int old;

        @Override
        public String toString() {
            return "Pets{" +
                    "name='" + name + '\'' +
                    ", old=" + old +
                    '}';
        }

        public Pets(String name, int old) {
            this.name = name;
            this.old = old;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getOld() {
            return old;
        }

        public void setOld(int old) {
            this.old = old;
        }

        public int compareTo(Object obj) {
            int old1 = this.getOld();
            int old2 = ((Pets) obj).getOld();
            return  old1>old2 ? 1 :(old1<old2 ? -1 :0);
        }
    }
}
