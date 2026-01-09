package imp_concepts.mutlithreading.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

class Eat implements Runnable{
    @Override
    public void run() {
        System.out.println("Eaten by :" + Thread.currentThread().getName() + " " + System.currentTimeMillis());
    }
}

class Cooked implements Runnable{
    @Override
    public void run() {
        System.out.println("Cooked by :" + Thread.currentThread().getName() + " " + System.currentTimeMillis());
    }
}

public class ScheduledThreadPool {
    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(3);
        executor.schedule(new Cooked(),2, TimeUnit.SECONDS);
        executor.scheduleAtFixedRate(new Eat(),1,10,TimeUnit.SECONDS);
        Thread.sleep(5000);
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);
    }
}
