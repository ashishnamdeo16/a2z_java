package imp_concepts.mutlithreading;

class evenThread extends Thread {
    private String Name;
    public evenThread(String Name){
        this.Name = Name;
    }
    @Override
    public void run(){
        for(int i=0;i<10;i++){
            if(i%2 == 0){
                System.out.println(i+ " " + Name);
            }
        }
    }

}

class oddThread extends Thread{
    private String Name;
    public oddThread(String Name){
        this.Name = Name;
    }

    @Override
    public void run(){
        for(int i=0;i<10;i++){
            if(i%2 != 0){
                System.out.println(i+ " " + Name);
            }
        }
    }
}

public class EvenOddThread {
    public static void main(String[] args) {
        evenThread t1 = new evenThread("Thread 1");
        oddThread t2 = new oddThread("Thread 2");
        t1.start();
        t2.start();
    }
}
