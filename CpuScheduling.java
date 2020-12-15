import java.util.*;
import java.text.DecimalFormat;

public class CpuScheduling {
    static Scanner userInput = new Scanner(System.in);
    private static DecimalFormat df = new DecimalFormat("0.00"); // used to format avg wt or avg tat to "0.00"
    public static void main(String[] args) {
        computeFCFS();
    }

    static void userOptions(){

        System.out.println("\nChoose CPU Scheduling [Non-Preemptive]Algorithm: ");
        System.out.println("[A] First Come First Serve Scheduling (FCFS)");
        System.out.println("[B] (SJF)");
        System.out.println("[C] Priority");
        System.out.println("[D] Deadline");
        System.out.println("[E] (MLQ)");
        System.out.println("[G] Exit\n");
        System.out.print("Choose Algorithm: ");
    }

    private static void computeFCFS() {
        System.out.print("Enter number of process: ");
        int inputProcess = userInput.nextInt();

        int[] processId = new int[inputProcess];  
        int[] arrivalTime = new int[inputProcess];   
        int[] burstTime = new int[inputProcess];   
        int[] completionTime = new int[inputProcess]; 
        int[] turnAroundTime = new int[inputProcess];  
        int[] waitingTime = new int[inputProcess];   
        int temporary;                   
        float avgWaitingTime = 0, avgTurnAroundTime = 0; 

        //get user input for arrival time and burst time of processes
        for(int i = 0; i < inputProcess; i++){
            System.out.print("Enter process " + (i+1) + " arrival time: ");
            arrivalTime[i] = userInput.nextInt();
            System.out.print("Enter process " + (i+1) + " burst time: ");
            burstTime[i] = userInput.nextInt();
            processId[i] = i+1;
        }
        //sort according to arrival time (fcfs)
        for(int i = 0; i < inputProcess; i++){
            for(int j = 0; j < inputProcess-(i+1); j++){
                if (arrivalTime[j] > arrivalTime[j+1]){
                    temporary = arrivalTime[j];
                    arrivalTime[j] = arrivalTime[j+1];
                    arrivalTime[j+1] = temporary;

                    temporary = burstTime[j];
                    burstTime[j] = burstTime[j+1];
                    burstTime[j+1] = temporary;

                    processId[j] = processId[j+1];
                    processId[j+1] = temporary;
                }
            }
        }

        //finding completion time
        for(int  i = 0 ; i < inputProcess; i++)
        {
            if( i == 0)
            {
                completionTime[i] = arrivalTime[i] + burstTime[i];
            }
            else
            {
                if( arrivalTime[i] > completionTime[i-1])
                {
                    completionTime[i] = arrivalTime[i] + burstTime[i];
                }
                else
                completionTime[i] = completionTime[i-1] + burstTime[i];
            }
            turnAroundTime[i] = completionTime[i] - arrivalTime[i] ;         // turnaround time= completion time- arrival time
            waitingTime[i] = turnAroundTime[i] - burstTime[i] ;              // waiting time= turnaround time- burst time
            avgWaitingTime += waitingTime[i] ;                               // total waiting time
            avgTurnAroundTime += turnAroundTime[i] ;                         // total turnaround time

        }
          //print output table
          System.out.println("\nProcess     AT     BT      CT      TAT      WT");
          for (int i = 0; i < inputProcess; i++){
              System.out.println(processId[i] + " \t\t\t" + arrivalTime[i] + "\t\t" + burstTime[i] + "\t\t" +
                      completionTime[i] + "\t\t" + turnAroundTime[i] + "\t\t"  + waitingTime[i]);
          }
  
          userInput.close();
          System.out.println("\nAverage Turnaround Time: " + df.format(avgTurnAroundTime/(float)inputProcess));
          System.out.println("Average Waiting Time: " + df.format(avgWaitingTime/(float)inputProcess));
    }
}
