package best_practise;

public class StackRunner {

    public static void main(String[] args) {
        MyStack<String> stack = new MyStack<>();
        stack.push("aaa");
        stack.push("bbb");
        stack.push("ccc");
        stack.push("fff");
        System.out.println(stack);
        System.out.println(stack.peek());
        System.out.println(stack.peek());
        System.out.println(stack.peek());
        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack);
    }
}


class MyStack<T> {

    private Node<T> head;

    public void push(T value) {
        Node<T> newNode = new Node<>(value);
        newNode.next = head;
        head = newNode;
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