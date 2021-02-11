package collections.list;

import java.util.Arrays;

public class MyLinkedList<E> {

    private Node<E> firstNode;

    //private Node<E> lastNode;

    private int size;

    public static void main(String[] args) {
        MyLinkedList<String> list = new MyLinkedList();
        list.add("My");
        list.add("name");
        list.add("is");
        list.add("Jenya");
        list.remove(3);
        list.add("Diego");
        list.remove(0);
        list.add("||");
        System.out.println(list);
    }

    public boolean add(E element) {
        if (size == 0) {
            Node<E> node = new Node<>(element, null);
            firstNode = new Node<>(null, node);
        } else {
            Node<E> temp = firstNode.next;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new Node<>(element, null);
        }
        size++;
        return true;
    }

    public E get(int index) {
        int idx = 0;
        Node<E> temp = firstNode.next;
        while (temp != null) {
            if (idx == index) {
                return temp.item;
            }
            temp = temp.next;
            idx++;
        }

        throw new IndexOutOfBoundsException("This index not contains!");
    }

    public boolean remove(int index) {
        if (index > size - 1 || index < 0) throw new IndexOutOfBoundsException("This index not contains!");

        if (index == 0) {
            firstNode = firstNode.next;
            size--;
        }

        Node<E> temp = firstNode.next;
        int idx = 0;

        while (temp != null) {
            if (idx == index - 1) {
                temp.next = temp.next.next;
                size--;
                return true;
            }
            temp = temp.next;
            idx++;
        }
        return false;
    }

    public String toString() {
        E[] res = ((E[]) new Object[size]);
        Node<E> temp = firstNode.next;
        int ids = 0;
        while (temp != null) {
            res[ids++] = temp.item;
            temp = temp.next;
        }
        return Arrays.toString(res);
    }

    private static class Node<E> {

        private Node<E> next;

        private E item;


        public Node(E item, Node<E> next) {
            this.next = next;
            this.item = item;
        }
    }
}

