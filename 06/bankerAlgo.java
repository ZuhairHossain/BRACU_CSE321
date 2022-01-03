import java.io.*;
import java.util.*;

public class bankerAlgo {
    public static void main(String[] args) {
        int process, resource;
        int[][] max_res, res_allocation, update_res_allocate, need;
        int[] current_res;
        char[]safe_seq;
        boolean[] flag;

        char [] process_id;
        File f= new File("input.txt");
        try{
            Scanner sc = new Scanner(f);
            process=sc.nextInt();
            resource=sc.nextInt();

            //INITIALIZING VARIABLES
            max_res=new int[process][resource];
            res_allocation=new int[process][resource];
            update_res_allocate=new int[process][resource];
            need=new int[process][resource];
            current_res=new int[resource];
            safe_seq=new char[process];
            flag=new boolean[process];
            process_id=new char[process];

            //process id insert
            int start=65;
            for(int i=0; i<process; i++){
                process_id[i]=(char)start;
                start++;
            }

            //max resolution part
            sc.nextLine();
            for(int i=0; i<process; i++){
                for(int j=0; j<resource; j++){
                    max_res[i][j]=sc.nextInt();
                }
            flag[i]=false;
            }

            // resource allocation part
            for(int i=0; i<process; i++){
                for(int j=0; j<resource; j++){
                    res_allocation[i][j]=sc.nextInt();
                }
            }

            //available resource part
            for(int j=0; j<resource; j++){
                current_res[j]=sc.nextInt();
            }

            //calculating need
            for (int i=0; i<process; i++){
                for(int j=0; j<resource; j++){
                    need[i][j]=max_res[i][j]-res_allocation[i][j];
                }
            }

            int done=0;
            while(done<process){
                int process_no=0;
                //compare for need
                for(int i=0; i<need.length; i++){
                    if(!flag[i]){
                        process_no=i;
                        boolean p_flag=true;
                        for(int j=0; j<need[i].length; j++){
                            if(need[i][j]>current_res[j]){
                                p_flag=false;
                                break;
                            }
                        }
                        flag[i]=p_flag;
                        if(p_flag){
                            break;
                        }
                    }
                }
                safe_seq[done]=process_id[process_no];
                //update current allocation
                for(int i=0; i<resource; i++){
                    current_res[i]=current_res[i]+res_allocation[process_no][i];
                    update_res_allocate[done][i]=current_res[i];
                }
                done++;
            }

            //output
            System.out.println("Need Matrix: ");
            for(int i=0; i<need.length; i++){
                for(int j=0; j<need[i].length; j++){
                    System.out.print(need[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println("Safe Sequence is: ");
            for(int i=0; i<safe_seq.length; i++){
                System.out.print(safe_seq[i]+" ");
            }
            System.out.println();
            System.out.println("Change in available resource matrix :");
            for(int i=0; i<need.length; i++){
                for(int j=0; j<need[i].length; j++){
                    System.out.print(update_res_allocate[i][j] + " ");
                }
                System.out.println();
            }
            sc.close();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
