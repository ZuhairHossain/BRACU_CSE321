package Assignment3_Zuhair_19101573;

class House implements Runnable{
    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println("The house is : " + threadName);
    }
}

public class task02{
    public static void main(String[] args){

        Thread h1 = new Thread(new House(),"House Stark");
        Thread h2 = new Thread(new House(),"House Targaryen");
        Thread h3 = new Thread(new House(),"House Lannister");
        Thread h4 = new Thread(new House(),"House Bolton");
        Thread h5 = new Thread(new House(),"House Tyrell");

        System.out.println("Single Threaded Mode...");
        h1.run();
        h2.run();
        h3.run();
        h4.run();

        System.out.println("Multi-Threaded Mode...");
        h1.setPriority(Thread.MAX_PRIORITY);
        h4.setPriority(Thread.MIN_PRIORITY);

        h1.start();
        h3.start();       
        h5.start();
        h4.start();

        try {
            h1.join();
            h3.join(); 
            h5.join();
            h4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if(h1.isAlive()){
            System.out.println("Not Today!");
        }
        if(!h4.isAlive()){
            System.out.println("You know nothing!");
        }
    }
}
