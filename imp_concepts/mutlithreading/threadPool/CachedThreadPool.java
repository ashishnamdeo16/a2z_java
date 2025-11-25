package imp_concepts.mutlithreading.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class CachedTask implements Runnable{
    private int task;

    public CachedTask(int task){
        this.task = task;
    }

    @Override
    public void run() {
        System.out.println(STR."\{Thread.currentThread().getName()} Uploading File No : " + task) ;
        try {
            Thread.sleep(110);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

public class CachedThreadPool {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();

        for(int i=1;i<11;i++){
           executor.submit(new CachedTask(i));
        }
        executor.shutdown();
        executor.awaitTermination(100, TimeUnit.SECONDS);
        System.out.print("All Tasks Completed");
    }
}
