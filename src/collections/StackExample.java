package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by Евгений on 06.05.2018.
 */
public class StackExample {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();
        stack.push("Do");
        stack.push("Re");
        stack.push("Mi");
        stack.push("Fa");
        stack.push("Sole");
        System.out.println(stack.peek());
        stack.pop();
        stack.pop();
        System.out.println(stack);
        stack.push("Fa");
        stack.push("Sole");
        stack.push("La");
        System.out.println(stack);
    }

}


class Stack<T> {
    private LinkedList<T> stack = new LinkedList<T>();

    public void push(T elem) {
        stack.addFirst(elem);
    }

    public T pop() {
        return stack.removeFirst();
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