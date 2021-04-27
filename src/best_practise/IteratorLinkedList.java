package best_practise;

import java.util.Iterator;

public class IteratorLinkedList {

    public static void main(String[] args) {
        LinkTList<Integer> list = new LinkTList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);

        Iterator<Integer> iter = list.reverseIter();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }
}

class LinkTList<T> {

    private Node<T> head;

    private Node<T> tail;

    private int size = 0;


    private static class Node<T> {

        public Node(T value) {
            this.value = value;
        }

        private Node<T> next;

        private Node<T> prev;

        private T value;

        @Override
        public String toString() {
            return "Node{" +
                    "next=" + next +
                    ", prev=" + prev +
                    ", value=" + value +
                    '}';
        }
    }


    public Iterator<T> iter() {
        return new IteratorTList<>();
    }

    public Iterator<T> reverseIter() {
        return new ReverseIteratorTList<>();
    }

    private class IteratorTList<T> implements Iterator<T> {

        int cursor = 0;

        @Override
        public boolean hasNext() {
            return cursor < size;
        }

        @Override
        public T next() {

            int step = 0;

            Node<T> node = (Node<T>) head;
            while (step++ < cursor) {
                node = node.next;
            }
            cursor++;
            return node.value;
        }
    }


    private class ReverseIteratorTList<T> implements Iterator<T> {

        int cursor = 0;

        @Override
        public boolean hasNext() {
            return cursor < size;
        }

        @Override
        public T next() {

            int step = 0;

            Node<T> node = (Node<T>) tail;
            while (step++ < cursor) {
                node = node.prev;
            }
            cursor++;
            return node.value;
        }
    }

    public void add(T value) {

        Node<T> newNode = new Node<>(value);
        newNode.prev = tail;

        if (head == null) {
            head = newNode;
        }

        if (tail != null) {
            tail.next = newNode;
        }

        tail = newNode;
        size++;
    }

}