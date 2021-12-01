package Assignment3_Zuhair_19101573;

public class task03 {
    static long fibarray[] = new long[50];
    static double[] mean = new double[4];

    static long fib(int n) {
        long a = 0, b = 1, c;
        if (n == 0)
            return a;
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }

    public static void main(String[] args) {

        for (int i = 0; i < 50; i++) {
            fibarray[i] = fib(i);
        }

        Thread f1 = new Thread(new Runnable() {
            @Override
            public void run() {
                long temp1 = 0;
                double count1 = 0;
                for (int i = 0; i < 25; i++) {
                    if (fibarray[i] % 2 != 0) {
                        count1++;
                        temp1 = temp1 + fibarray[i];
                    }
                }
                mean[0] = (double) temp1 / count1;
            }
        }, "oddMeanFirst");

        Thread f2 = new Thread(new Runnable() {
            @Override
            public void run() {
                long temp2 = 0;
                double count2 = 0;
                for (int i = 0; i < 25; i++) {
                    if (fibarray[i] % 2 == 0) {
                        count2++;
                        temp2 = temp2 + fibarray[i];
                    }
                }
                mean[1] = (double) temp2 / count2;
            }
        }, "evenMeanFirst");
        Thread f3 = new Thread(new Runnable() {
            @Override
            public void run() {
                long temp3 = 0;
                double count3 = 0;
                for (int i = 25; i < 50; i++) {
                    if (fibarray[i] % 2 != 0) {
                        count3++;
                        temp3 = temp3 + fibarray[i];
                    }
                }
                mean[2] = (double) temp3 / count3;
            }
        }, "oddMeanSecond");
        Thread f4 = new Thread(new Runnable() {
            @Override
            public void run() {
                long temp4 = 0;
                double count4 = 0;
                for (int i = 25; i < 50; i++) {
                    if (fibarray[i] % 2 == 0) {
                        count4++;
                        temp4 = temp4 + fibarray[i];
                    }
                }
                mean[3] = (double) temp4 / count4;
            }
        }, "evenMeanSecond");

        f1.start();
        f2.start();
        f3.start();
        f4.start();

        try {
            f1.join();
            f2.join();
            f3.join();
            f4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread f5 = new Thread(new Runnable() {
            @Override
            public void run() {
                double result = 0.0;
                for (int i = 0; i < 4; i++) {
                    result = result + mean[i];
                }
                System.out.println("The special integer is " + (int) (result / 4.0));
            }
        }, "avgMean");

        f5.start();
    }
}