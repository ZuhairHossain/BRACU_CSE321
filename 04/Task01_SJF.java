package com.company;
import java.util.Scanner;
public class Task01_SJF {

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Total number of processes: ");
        int n= sc.nextInt();

        System.out.println();

        int[] pid = new int[n];
        int[] arrivalTime = new int[n];
        int[] burstTime = new int[n];
        int[] completeTime = new int[n];
        int[] turnAroundTime = new int[n];
        int[] waitingTime = new int[n];
        int[] flag = new int[n];
        int[] final_burst = new int[n];
        int startTime=0, taTime=0;
        float total_waitingTime=0, total_TurnAroundTime=0;

        for (int i=0; i<n; i++) {
            pid[i] = i+1;
            System.out.print("P"+(i+1)+ " Arrival time= ");
            arrivalTime[i] = sc.nextInt();
            System.out.print("P" + (i+1) + " Burst time= ");
            burstTime[i] = sc.nextInt();
            final_burst[i] = burstTime[i];
            flag[i] = 0;
        }

        while(true) {

            int min=999, count=n;
            if (taTime == n) {
                break;
            }

            for (int i=0; i<n; i++) {
                if ( (arrivalTime[i] <= startTime) && (flag[i] == 0) && (burstTime[i] < min) ) {
                    min = burstTime[i];
                    count = i;
                }
            }

            if (count == n) {
                startTime++;
            }

            else {
                burstTime[count]--;
                startTime++;
                if (burstTime[count] == 0) {
                    completeTime[count] = startTime;
                    flag[count] = 1;
                    taTime++;
                }
            }
        }

        for(int i=0; i<n; i++) {
            turnAroundTime[i] = completeTime[i] - arrivalTime[i];
            waitingTime[i] = turnAroundTime[i] - final_burst[i];
            total_waitingTime += waitingTime[i];
            total_TurnAroundTime += turnAroundTime[i];
        }

        System.out.println();
        System.out.println("Process  arrival  burst  complete TAT waiting");

        for(int i=0; i<n; i++) {
            System.out.println("P"+pid[i] +"\t"+ arrivalTime[i]+"\t"+ final_burst[i] +"\t"+ completeTime[i] +"\t"+ turnAroundTime[i] +"\t"+ waitingTime[i]);
        }

        System.out.println();
        System.out.println("The Average Turn Around Time (TAT) = " + (total_TurnAroundTime/n));
        System.out.println("The Average Waiting Time = " + (total_waitingTime/n));
        sc.close();
    }
}