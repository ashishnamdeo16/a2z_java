package imp_concepts.mutlithreading;

public class usingRunnable implements Runnable {
    public static void main(String[] args) throws InterruptedException {
        usingRunnable task = new usingRunnable();

        Thread A = new Thread(task,"A");
        Thread B = new Thread(task,"B");
        A.start();
        A.join();
        B.start();
        B.join();
        System.out.println("Main Completed");
    }

    @Override
    public void run() {
        System.out.println("Inside " + Thread.currentThread().getName());
    }
}
