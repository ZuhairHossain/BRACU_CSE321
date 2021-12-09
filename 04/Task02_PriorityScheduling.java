package com.company;

import java.util.Scanner;

public class Task02_PriorityScheduling {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Total number of processes: ");
        int n = sc.nextInt();

        System.out.println();

        int[] pid = new int[n];
        int[] burstTime = new int[n];
        int[] priority = new int[n];
        int[] turnAroundTime = new int[n];
        int[] waitingTime = new int[n];
        int completed = 0;
        float total_waitingTime = 0, total_TurnAroundTime = 0;

        for (int i=0; i<n; i++) {
            pid[i] = i+1;
            System.out.print("P" + (i+1) + " Burst time= ");
            burstTime[i] = sc.nextInt();
            System.out.print("P" + (i+1) + " Priority= ");
            priority[i] = sc.nextInt();
        }

        while(completed != n) {

            for (int i=completed+1; i< n; i++) {
                if (priority[completed] == priority[i] ) {

                    int temp = priority[completed];
                    priority[completed] = priority[i];
                    priority[i] = temp;

                    int temp2 = burstTime[completed];
                    burstTime[completed] = burstTime[i];
                    burstTime[i] = temp2;
                }
            }
            completed++;
        }

        waitingTime[0] = 0;
        turnAroundTime[0] = burstTime[0];

        for(int i=1; i<n; i++) {
            turnAroundTime[i] = waitingTime[i] + burstTime[i];
            waitingTime[i] = turnAroundTime[i-1];
            total_waitingTime += waitingTime[i];
            total_TurnAroundTime += turnAroundTime[i];
        }

        System.out.println();
        System.out.println("Process Burst Priority TAT Waiting");

        for(int i=0; i<n; i++) {
            System.out.println("P"+pid[i] +"\t"+ burstTime[i] +"\t"+ priority[i] + "\t"+ turnAroundTime[i] +"\t"+ waitingTime[i]);
        }

        System.out.println();
        System.out.println("The Average Turn Around Time (TAT) = " + (total_TurnAroundTime/n));
        System.out.println("The Average Waiting Time = " + (total_waitingTime/n));
        sc.close();
    }
}
