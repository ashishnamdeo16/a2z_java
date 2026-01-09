package imp_concepts.mutlithreading.threadPool;

import java.util.concurrent.*;

public class FutureExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<String> task = () -> {
            Thread.sleep(500);
            return "Task 1 completed";
        };

        ExecutorService executor = Executors.newFixedThreadPool(2);
        Future<String> future = executor.submit(task);
        String result = future.get();
        System.out.println(result);
        executor.shutdown();
    }
}
