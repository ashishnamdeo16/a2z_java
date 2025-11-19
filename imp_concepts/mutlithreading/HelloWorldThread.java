package imp_concepts.mutlithreading;

class HelloThread extends Thread{

    @Override
    public void run() {
        for(int i=0;i<5;i++){
            System.out.println("Hello From Thread");
            try{
                Thread.sleep(1000);
            }catch(Exception e){
                System.out.print("Exception" + e);
            }

        }
    }
}

public class HelloWorldThread {
    public static void main(String[] args) throws InterruptedException {
        HelloThread t2 = new HelloThread();
        t2.start();
        t2.join();
        System.out.print("Completed");
    }
}


