package com.company;
import java.util.Scanner;

public class Task03_RoundRobin {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Total number of processes: ");
        int n = sc.nextInt();

        int[] burstTime = new int[n];
        int[] waitingTime = new int[n];
        int[] turnAroundTime = new int[n];
        int[]  remainingBurst = new int[n];

        int count=0, temp, sq=0;
        float total_waitingTime = 0, total_TurnAroundTime = 0;

        System.out.print("Enter the Burst times of the processes\n");
        for (int i=0; i<n; i++) {
            System.out.print("P"+(i+1)+" = ");
            burstTime[i] = sc.nextInt();
            remainingBurst[i] = burstTime[i];
        }
        System.out.print("Enter quantum time = ");
        int quantumTime = sc.nextInt();

        while(count!=n) {
            for (int i=0; i<n; i++) {
                temp = quantumTime;

                if(remainingBurst[i] == 0) {
                    count++;
                    continue;
                }

                if(remainingBurst[i] > quantumTime)
                    remainingBurst[i]= remainingBurst[i] - quantumTime;

                else if(remainingBurst[i] >= 0) {
                    temp = remainingBurst[i];
                    remainingBurst[i] = 0;
                }
                sq = sq + temp;
                turnAroundTime[i] = sq;
            }
        }

        for(int i=0; i<n; i++) {
            waitingTime[i] = turnAroundTime[i] - burstTime[i];
            total_waitingTime = total_waitingTime + waitingTime[i];
            total_TurnAroundTime = total_TurnAroundTime + turnAroundTime[i];
        }

        System.out.println();
        System.out.println("Process Burst TAT Waiting");
        for(int i=0; i<n; i++) {
            System.out.println("P"+(i+1)+"\t  " + burstTime[i]+"\t   " + turnAroundTime[i] + "\t   " + waitingTime[i]);
        }

        System.out.println();
        System.out.println("Average waiting Time = "+(total_waitingTime/n));
        System.out.println("Average turnaround time = "+(total_TurnAroundTime/n));
        sc.close();
    }
}