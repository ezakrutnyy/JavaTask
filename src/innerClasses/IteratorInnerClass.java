package innerClasses;

/**
 * Created by Евгений on 04.05.2018.
 */

public class IteratorInnerClass {
    public static void main(String[] args) {
        final int cnt = 7;
        Sequence sequence = new Sequence(cnt);
        for (int j = 0; j < cnt; j++) {
            sequence.add(j);
        }

        Selector selector = sequence.reverseSelector();
        while (selector.hashNext()) {
            Object elem = selector.current();
            System.out.println(elem);
            selector.next();
        }

    }
}

interface Selector {
    boolean hashNext();
    void next();
    Object current();
}

class Sequence {
    private Object[] items;
    private int next = 0;

    public Sequence(int size) {
        items = new Object[size];
    }

    public void add(Object obj) {
        if (next<items.length) {
            items[next++] = obj;
        }
    }

    private class SequenceSelector implements Selector {

        private int i = 0;

        @Override
        public boolean hashNext() {
            if (i<items.length) {
                return true;
            }
            return false;
        }

        @Override
        public void next() {
            if (i<items.length) {
                i++;
            }

        }

        @Override
        public Object current() {
            return items[i];
        }


    }

    private class ReverseSelector implements Selector {

        private int i = items.length-1;

        @Override
        public boolean hashNext() {
            if (i>=0) {
                return true;
            }
            return false;
        }

        @Override
        public void next() {
            if (i>=0) {
                i--;
            }

        }

        @Override
        public Object current() {
            return items[i];
        }


    }

    Selector selector() {
        return new SequenceSelector();
    }

    Selector reverseSelector() {
        return new ReverseSelector();
    }

}