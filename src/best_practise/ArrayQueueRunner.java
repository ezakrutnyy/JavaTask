package best_practise;

import java.util.Arrays;

public class ArrayQueueRunner {


    public static void main(String[] args) {

        ArrayQueue<Integer> queue = new ArrayQueue<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);
        System.out.println(queue);
        queue.poll();
        queue.poll();
        queue.poll();
        queue.poll();
        queue.poll();
        queue.poll();
        queue.poll();
        queue.poll();
        queue.poll();
        queue.poll();
        System.out.println("-----------");
        System.out.println(queue);

        queue.offer(10);
        queue.offer(20);
        queue.offer(30);
        queue.offer(40);
        queue.offer(50);
        queue.offer(60);
        System.out.println("-----------");
        System.out.println(queue);
        queue.poll();
        queue.poll();
        queue.poll();
        System.out.println("-----------");
        System.out.println(queue);
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        System.out.println("-----------");
        System.out.println(queue);
        queue.poll();
        queue.poll();
        System.out.println("-----------");
        System.out.println(queue);
    }
}


class ArrayQueue<T> {

    private int headIndex = 0;

    private int tailIndex = 0;

    private final static int CAPACITY_MAX = 5;

    private int size = 0;

    ArrayQueue() {
        this.value = (T[]) new Object[CAPACITY_MAX];
    }

    private final T[] value;


    public void offer(T elem) {

        if (size >= CAPACITY_MAX) return;

        if (value[headIndex] == null) {
            value[headIndex] = elem;
        }

        if (value[tailIndex] == null) {
            value[tailIndex] = elem;
        }

        size++;
        tailIndex = addIndex(tailIndex);
    }

    private int addIndex(int index) {
        return index + 1 == CAPACITY_MAX ? 0 : ++index;
    }


    T poll() {

        if (size == 0) return null;

        T elem = value[headIndex];
        value[headIndex] = null;
        headIndex = addIndex(headIndex);
        size--;
        return elem;
    }

    @Override
    public String toString() {
        return "ArrayQueue{" +
                "headIndex=" + headIndex +
                ", tailIndex=" + tailIndex +
                ", size=" + size +
                ", value=" + Arrays.toString(value) +
                '}';
    }
}