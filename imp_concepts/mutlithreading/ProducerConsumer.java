package imp_concepts.mutlithreading;

class SharedResource{
    public int data;
    public boolean hasData;

    public synchronized void producer(int data) throws InterruptedException{
        while(hasData) {
            wait();
        }
        this.data = data;
        hasData = true;
        notify();
    }

    public synchronized int consumer() throws InterruptedException{
        while(!hasData) {
            wait();
        }
        hasData = false;
        notify();
        return data;
    }
}

class Producer extends Thread{
    private SharedResource data;

    public Producer(SharedResource data) {
        this.data = data;
    }

    @Override
    public void run() {
        try {
            for(int i = 1; i <= 10; i++) {
                System.out.println("Produced: " + i);
                data.producer(i);
                Thread.sleep(500);
            }

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class Consumer extends Thread{
    SharedResource data;

    public Consumer(SharedResource resource) {
        this.data = resource;
    }

    @Override
    public void run() {
        try {
            for(int i = 1; i <= 10; i++) {
                int val = data.consumer();
                System.out.println("Consumed: " + val);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}


public class ProducerConsumer {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();
        Producer farmer = new Producer(resource);
        Consumer crowd = new Consumer(resource);

        farmer.start();
        crowd.start();
    }
}
