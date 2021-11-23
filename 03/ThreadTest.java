class MyThread extends Thread {

    public MyThread(String name) {
        super(name);
    }


    public void run() {
        System.out.println("Hello World");
        System.out.println(Thread.currentThread().getName());
    }
}

class MyThreadFromRunnable implements Runnable{
    public void run() {
        System.out.println("Hello World");
        System.out.println(Thread.currentThread().getName());
    }
}

public class ThreadTest {
    public static void main(String[] args) {
        MyThread myThread = new MyThread("My Thread 1");
        Thread mytThreadRunnable = new Thread(new MyThreadFromRunnable(), "MyThread2");
        mytThreadRunnable.start();
        myThread.start();
    }
}