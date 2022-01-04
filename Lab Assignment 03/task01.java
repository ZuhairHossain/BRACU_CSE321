package Assignment3_Zuhair_19101573;

import java.util.*;

public class task01 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter two inputs: ");
        int n1 = scanner.nextInt();
        int n2= scanner.nextInt();
        

        // tried taking user input here as well, but some issue occurred so removed that
        
        Operation add = new Operation("add", n1,n2);
        Operation sub = new Operation("sub", n1,n2);
        Operation mul = new Operation("mul", n1,n2);
        Operation div = new Operation("div", n1,n2);
        Operation oth = new Operation("oth", n1,n2);

        scanner.close();
    }
}

class Operation implements Runnable{
    int a,b;
    Thread t;
    String threadName;

    public Operation(String threadName, int a, int b){
        t = new Thread(this);
        this.threadName = threadName;
        this.a = a;
        this.b = b;
        t.start();
    }

    @Override
    public void run() {
        if(threadName.compareTo("add") == 0){
            System.out.println("The result is " + (a + b) + " from " + threadName);
        }
        else if(threadName.compareTo("sub")==0){
            if(a>b){
                System.out.println("The result is " + (a - b) + " from " + threadName);
            }
            else{
                System.out.println("The result is " + (b - a) + " from " + threadName);
            }
        }
        else if(threadName.compareTo("mul")==0){
            System.out.println("The result is " + (a * b) + " from " + threadName);
        }
        else if(threadName.compareTo("div")==0){
            try{
                System.out.println("The result is " + (a / b) + " from " + threadName);
            }
            catch(Exception e){
                System.out.println("Can't be divisible by 0");
            }
        }
        else{
            System.out.println("No valid operation from " + threadName);
        }
    }
}


