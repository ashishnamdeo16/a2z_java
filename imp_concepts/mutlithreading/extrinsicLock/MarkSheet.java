package imp_concepts.mutlithreading.extrinsicLock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class StudentMarks{
    int marks = 0;
    ReadWriteLock lock = new ReentrantReadWriteLock();

    public void viewMarks(){
        lock.readLock().lock();
        try{
            System.out.println(marks);
        }finally{
            lock.readLock().unlock();
        }
    }

    public void UpdateMarks(int marks){
        lock.writeLock().lock();
        try{
            this.marks += marks;
            System.out.println("New Marks : " + this.marks);
            Thread.sleep(1002);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally{
            lock.writeLock().unlock();
        }
    }
}

class StudentReader extends Thread{
    StudentMarks sm;

    public StudentReader(StudentMarks sm){
        this.sm = sm;
    }

    @Override
    public void run() {
        sm.viewMarks();
    }
}

class TeacherWriter extends Thread{
    StudentMarks sm;
    int marksToAdd;

    public TeacherWriter(StudentMarks sm, int marksToAdd){
        this.sm = sm;
        this.marksToAdd = marksToAdd;
    }

    @Override
    public void run() {
        sm.UpdateMarks(marksToAdd);
    }
}

public class MarkSheet {
    public static void main(String[] args) {
        StudentMarks sm = new StudentMarks();
        for(int i=1;i<=3;i++){
            new StudentReader(sm).start();
        }
        TeacherWriter t2 = new TeacherWriter(sm,12);
        t2.start();
        for(int i=4;i<=6;i++){
            new StudentReader(sm).start();
        }
        TeacherWriter t3 = new TeacherWriter(sm,25);
        t3.start();
        for(int i=4;i<=6;i++){
            new StudentReader(sm).start();
        }
    }
}
