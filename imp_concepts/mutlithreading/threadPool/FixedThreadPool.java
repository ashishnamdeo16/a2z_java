package imp_concepts.mutlithreading.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class UploadFile implements Runnable{
    private int fileNumber;

    public UploadFile(int fileNumber) {
        this.fileNumber = fileNumber;
    }

    @Override
    public void run() {
            System.out.println(STR."\{Thread.currentThread().getName()} Uploading File No : " + fileNumber) ;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.print(e);
            }
    }
}

public class FixedThreadPool {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(7);
        for(int i=1;i<11;i++){
            executor.submit(new UploadFile(i));
        }
        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS);
        System.out.println("All uploads done");
    }
}
