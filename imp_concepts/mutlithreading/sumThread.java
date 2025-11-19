package imp_concepts.mutlithreading;

class WorkerThread extends Thread{
    public int sum;
    public int[] arr;

    public WorkerThread(int[] arr){
        this.arr = arr;
    }


    @Override
    public void run() {
        for(int i=0;i<arr.length;i++){
            sum += arr[i];
        }
    }

    public int getSum(){
        return sum;
    }

}

public class sumThread {
    public static void main(String[] args) throws InterruptedException {
        int[] arr = {1,2,3,2};
        WorkerThread t1 = new WorkerThread(arr);
        t1.start();
        t1.join();
        System.out.print(t1.getSum());
    }
}
