package best_practise;

public class QueueRunner {

    public static void main(String[] args) {
        MyQueue<String> myQueue = new MyQueue<>();
        myQueue.push("aaa");
        myQueue.push("bbb");
        myQueue.push("ccc");
        myQueue.push("fff");
        System.out.println(myQueue);
        System.out.println(myQueue.peek());
        System.out.println(myQueue.peek());
        System.out.println(myQueue.peek());
        System.out.println(myQueue);
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
        System.out.println(myQueue);
    }
}

class MyQueue<T> {

    private Node<T> head;

    private Node<T> tail;

    public void push(T value) {

        Node<T> newNode = new Node<>(value);

        if (head == null) {
            head = newNode;
        }

        if (tail != null) {
            tail.next = newNode;
        }

        tail = newNode;
    }

    public T peek() {
        if (head == null) return null;

        return head.value;
    }

    public T pop() {
        if (head == null) return null;

        T currentValue = head.value;
        head = head.next;
        return currentValue;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        Node<T> currentNode = head;
        while (currentNode != null) {
            sb.append(currentNode.value).append("|");
            currentNode = currentNode.next;
        }
        sb.append("}");
        return sb.toString();
    }

    private static class Node<T> {

        private final T value;

        private Node<T> next;

        private Node(T value) {
            this.value = value;
        }
    }
}
