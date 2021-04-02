package concurrency.atomics;

import java.util.concurrent.atomic.AtomicReference;

public class TraiberStackRun {

    public static void main(String[] args) {
        TraiberStack<String> stack = new TraiberStack<>();
        stack.push("aaaa");
        stack.push("bbbb");
        stack.push("zzzz");
        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println("Ended");
        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}

class TraiberStack<T> {

    private AtomicReference<Node<T>> tail = new AtomicReference<>();

    public void push(T value) {
        Node<T> newTail = new Node<>(value, null);
        while (true) {
            Node<T> oldTail = this.tail.get();
            newTail.next = oldTail;
            if (this.tail.compareAndSet(oldTail, newTail)) {
                break;
            }
        }
    }

    public T pop() {
        while (true) {
            Node<T> oldTail = this.tail.get();
            if (oldTail == null) {
                return null;
            }

            Node<T> newTail = oldTail.next;
            if (this.tail.compareAndSet(oldTail, newTail)) {
                return oldTail.value;
            }
        }
    }

    private static class Node<E> {

        private Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }

        private E value;

        private Node<E> next;

    }

    @Override
    public String toString() {
        Node<T> startElement = tail.get();

        if (tail == null) return "{}";

        String str = "{";

        while (startElement != null) {

            str += startElement.value + ";";
            startElement = startElement.next;
        }
        str += "}";
        return str;
    }
}
