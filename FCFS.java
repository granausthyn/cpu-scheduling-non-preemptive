import java.util.Scanner;  

public class FCFS{


    // Function to find the waiting time for all 
    // processes 
    static void findWaitingTime(int processes[], int n, int burstTime[], int waitingTime[], int arrivalTime[]) 
    { 
        int serviceTime[] = new int[n]; 
        serviceTime[0] = 0; 
        waitingTime[0] = 0; 
    
        // calcularrivalTimeing waiting time 
        for (int i = 1; i < n ; i++) 
        { 
            //representing wasted time in queue
            int wasted=0;
            // Add burst time of previous processes 
            serviceTime[i] = serviceTime[i-1] + burstTime[i-1]; 
    
            // Find waiting time for current process = 
            // sum - arrivalTime[i] 
            waitingTime[i] = serviceTime[i] - arrivalTime[i]; 
    
            // If waiting time for a process is in negarrivalTimeive 
            // tharrivalTime means it is already in the ready queue 
            // before CPU becomes idle so its waiting time is 0 
            // wasted time is basically time for process to wait after a process is over
            if (waitingTime[i] < 0) {
                wasted = Math.abs(waitingTime[i]);
                waitingTime[i] = 0; 
            }
            //Add wasted time
            serviceTime[i] = serviceTime[i] + wasted;
        } 
    } 
    
    // Function to calcularrivalTimee turn around time 
    static void findTurnAroundTime(int processes[], int n, int burstTime[], 
                                        int waitingTime[], int tarrivalTime[]) 
    { 
        // CalcularrivalTimeing turnaround time by adding burstTime[i] + waitingTime[i] 
        for (int i = 0; i < n ; i++) 
            tarrivalTime[i] = burstTime[i] + waitingTime[i]; 
    } 
    
    // Function to calcularrivalTimee average waiting and turn-around 
    // times. 
    static void findavgTime(int processes[], int n, int burstTime[], int arrivalTime[]) 
    { 
        int waitingTime[] = new int[n], tarrivalTime[] = new int[n]; 
    
        // Function to find waiting time of all processes 
        findWaitingTime(processes, n, burstTime, waitingTime, arrivalTime); 
    
        // Function to find turn around time for all processes 
        findTurnAroundTime(processes, n, burstTime, waitingTime, tarrivalTime); 
    
        // Display processes along with all details 
        System.out.print("Processes " + " Burst Time " + " Arrival Time "
            + " Waiting Time " + " Turn-Around Time "
            + " Completion Time \n"); 
        int total_waitingTime = 0, total_tarrivalTime = 0; 
        for (int i = 0 ; i < n ; i++) 
        { 
            total_waitingTime = total_waitingTime + waitingTime[i]; 
            total_tarrivalTime = total_tarrivalTime + tarrivalTime[i]; 
            int compl_time = tarrivalTime[i] + arrivalTime[i]; 
            System.out.println(i+1 + "\t\t" + burstTime[i] + "\t\t"
                + arrivalTime[i] + "\t\t" + waitingTime[i] + "\t\t "
                + tarrivalTime[i] + "\t\t " + compl_time); 
        } 
    
        System.out.print("Average waiting time = "
            + (float)total_waitingTime / (float)n); 
        System.out.print("\nAverage turn around time = "
            + (float)total_tarrivalTime / (float)n); 
    } 
    
    // Driver code 
    
        public static void main(String args[]) { 
            // Process id's 
        //int processes[] = {1, 2, 3}; 
        //int n = processes.length; 
    
        // Burst time of all processes 
        //int burst_time[] = {5, 9, 6}; 
    
        // Arrival time of all processes 
        //int arrival_time[] = {0, 3, 6}; 
        takeInput();
       
    
        }

        static void takeInput(){
            int n;  
            Scanner sc=new Scanner(System.in);  
            System.out.print("Input number of Processes: ");  
            //reading the number of elements from the that we want to enter  
            n=sc.nextInt();  
            
            int processID[] = new int[n];
            for(int i = 0; i < n; i++){
                processID[i] = (i+1);
            }
            int processesLength = processID.length;  
            int burstTime[] = new int[n];
            int arrivalTime[] = new int[n];
           

            for(int ctr = 0; ctr<n; ctr++){
                System.out.print("Enter process " + (ctr+1) + " arrival time: ");
                arrivalTime[ctr] = sc.nextInt();
                System.out.print("Enter process " + (ctr+1) + " burst time: ");
                burstTime[ctr] = sc.nextInt();
                
            }
            findavgTime(processID, processesLength, burstTime, arrivalTime);  


            
            sc.close();
        }
        
    } 
    

    