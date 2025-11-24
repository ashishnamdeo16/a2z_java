package imp_concepts.mutlithreading.deadlock;

class Pen{
    public void startWriting(){
        System.out.println("Starting Wrting with Pen");
    }
}

class NoteBook{
    public void startWriting(){
        System.out.println("Starting Wrting on Notebook");
    }
}

class Person1 extends Thread{
    final Pen pen;
    final NoteBook notebook;

    public Person1(Pen pen, NoteBook notebook) {
        this.pen = pen;
        this.notebook = notebook;
    }

    @Override
    public void run() {
        synchronized(pen){
            pen.startWriting();
            try {
                Thread.sleep(1000); // simulate delay
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            synchronized(notebook) {
                notebook.startWriting();
            }
        }
    }
}

class Person2 extends Thread{
    final Pen pen;
    final NoteBook notebook;

    public Person2(Pen pen, NoteBook notebook) {
        this.pen = pen;
        this.notebook = notebook;
    }

    @Override
    public void run() {
        synchronized(pen){
            pen.startWriting();
            try {
                Thread.sleep(1000); // simulate delay
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            synchronized(notebook) {
                notebook.startWriting();
            }
        }
    }
}


public class DeadLockExample {
    public static void main(String[] args) {
        Pen pen = new Pen();
        NoteBook NoteBook = new NoteBook();
        Person1 t1 = new Person1(pen,NoteBook);
        t1.start();
        Person2 t2  = new Person2(pen,NoteBook);
        t2.start();
    }
}
