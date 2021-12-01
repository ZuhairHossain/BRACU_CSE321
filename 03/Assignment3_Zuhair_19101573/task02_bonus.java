package Assignment3_Zuhair_19101573;

class House_bonus implements Runnable{
    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println("The house is : " + threadName);

                try {
            if (threadName.compareTo("House Stark") == 0 || threadName.compareTo("House Targaryen") == 0) {
                Thread.sleep(1000);
            }
            else if (threadName.compareTo("House Lannister") == 0 || threadName.compareTo("House Bolton") == 0) {
                Thread.sleep(3000);
            }
            else{
                Thread.sleep(5000);
            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class task02_bonus{
    public static void main(String[] args){

        Thread h1 = new Thread(new House_bonus(),"House Stark");
        Thread h2 = new Thread(new House_bonus(),"House Targaryen");
        Thread h3 = new Thread(new House_bonus(),"House Lannister");
        Thread h4 = new Thread(new House_bonus(),"House Bolton");
        Thread h5 = new Thread(new House_bonus(),"House Tyrell");

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
