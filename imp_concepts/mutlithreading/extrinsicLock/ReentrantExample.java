package imp_concepts.mutlithreading.extrinsicLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Counter{
    private int count = 0;
    private final Lock lock = new ReentrantLock();

    public void increament(){
        lock.lock();
        try{
            for(int i=0;i<10000;i++){
                count++;
            }
        }finally{
            lock.unlock();
        }

    }

    public int getCount(){
        return count;
    }
}

public class ReentrantExample extends Thread {
    public static void main(String[] args) throws InterruptedException {
        Counter count = new Counter();
        Thread t1 = new Thread(count::increament);
        Thread t2 = new Thread(count::increament);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.print(count.getCount());

    }
}
