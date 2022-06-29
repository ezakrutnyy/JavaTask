package collections.queue;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created by Евгений on 06.05.2018.
 */
public class PriorityQueueRunner {
    public static void main(String[] args) {

        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(Collections.reverseOrder());
        queue.offer(5);
        queue.offer(1);
        queue.offer(12);
        queue.offer(8);
        queue.offer(56);
        queue.offer(6);
        queue.offer(4);
        queue.offer(2);
        queue.offer(3);
        queue.offer(44);

        System.out.println(queue);

        queue.poll();
        queue.poll();
        queue.poll();
        queue.poll();
        System.out.println(queue);
        queue.poll();
        queue.poll();
        queue.poll();
        System.out.println(queue);
        queue.poll();
        queue.poll();
        queue.poll();
        queue.poll();

        System.out.println(queue);
    }
}


