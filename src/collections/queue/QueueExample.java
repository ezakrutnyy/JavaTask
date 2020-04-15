package collections.queue;

import java.util.LinkedList;

/**
 * Created by Евгений on 06.05.2018.
 */
public class QueueExample{
    public static void main(String[] args) {
        Queue<String> queue = new Queue<String>();
        queue.push("Do");
        queue.push("Re");
        queue.push("Mi");
        queue.push("Fa");
        queue.push("Sole");
        System.out.println(queue);
        System.out.println(queue.peek());
        queue.pop();
        queue.pop();
        System.out.println(queue);
        queue.push("Fa");
        queue.push("Sole");
        queue.push("La");
        System.out.println(queue);
    }
}

class Queue<T> {

    private LinkedList<T> stack = new LinkedList<>();

    public void push(T elem) {
        stack.offer(elem);
    }

    public T pop() {
        return stack.remove();
    }

    public T peek() {
        return stack.getFirst();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public String toString() {
        return stack.toString();
    }

}