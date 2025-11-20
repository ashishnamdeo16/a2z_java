package imp_concepts.mutlithreading;

class Deposite1 extends Thread{
    private account acc;
    private int bal;

    public Deposite1(account acc,int bal){
        this.acc = acc;
        this.bal = bal;
    }

    @Override
    public void run() {
        acc.deposite(bal);
    }
}

class Deposite2 extends Thread{
    private account acc;
    private int bal;

    public Deposite2(account acc,int bal){
        this.acc = acc;
        this.bal = bal;
    }

    @Override
    public void run() {
        acc.deposite(bal);
    }
}

class account{
    private int balance = 0;

    public synchronized void deposite(int amt){
        int oldBalance = balance;
        System.out.println("Depositing");
        balance = oldBalance + amt;
        System.out.println(Thread.currentThread().getName() +
                " oldBalance=" + oldBalance +
                " newBalance=" + balance);
        System.out.println("Deposited Successfully" );
    }

    public int getBalance() {
        return balance;
    }
}

public class BankAccount extends Thread {
    public static void main(String[] args) throws InterruptedException {
        account acc = new account();

        Deposite1 t1 = new Deposite1(acc,100);
        Deposite2 t2 = new Deposite2(acc,200);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Final balance: " + acc.getBalance());
    }
}
