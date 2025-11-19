package imp_concepts.mutlithreading;

class alphabetsA2Z implements Runnable{
    @Override
    public void run() {
        for(int i=1;i<27;i++){
            System.out.println((char) (i+64) + " " + "Thread 1");
        }
    }
}

class numbers implements Runnable{
    @Override
    public void run() {
        for(int i=1;i<27;i++){
            System.out.println(i + " " + "Thread 2");
        }
    }
}

public class MyThread {
    public static void main(String[] args) throws InterruptedException {
        alphabetsA2Z t1 = new alphabetsA2Z();
        numbers t2 = new numbers();
        Thread a = new Thread(t1);
        Thread b = new Thread(t2);
        a.start();
        b.start();


    }
}
