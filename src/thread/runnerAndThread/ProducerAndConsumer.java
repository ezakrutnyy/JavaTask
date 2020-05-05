package thread.runnerAndThread;

public class ProducerAndConsumer {
    public static void main(String[] args) {
        Product p = new Product();
        Producer producer = new Producer(p, 7);
        Consumer consumer = new Consumer(p, 7);
        producer.start();
        consumer.start();
    }
}

class Producer extends Thread {

    Product p;

    int count;

    public Producer(Product p, int count) {
        this.p = p;
        this.count = count;
    }

    @Override
    public void run() {
        for (int k = 1; k <= count; k++) {
            p.setId(k);
        }
    }
}

class Consumer extends Thread {

    public Consumer(Product p, int count) {
        this.p = p;
        this.count = count;
    }

    Product p;

    int count;

    @Override
    public void run() {
        for (int k = 1; k <= count; k++) {
            p.getId();
        }
    }
}


class Product {

    boolean isProduced;

    int id;

    synchronized public void getId() {
        if (!isProduced) {
            try {
                wait();
            } catch (InterruptedException ex) {
            }
        }
        System.out.println("get id:"+this.id);
        isProduced = false;
        notify();
    }

    synchronized public void setId(int id) {
        if (isProduced) {
            try {
                wait();
            } catch (InterruptedException ex) {
            }
        }
        this.id = id;
        System.out.println("set id:"+this.id);
        isProduced = true;
        notify();
    }
}