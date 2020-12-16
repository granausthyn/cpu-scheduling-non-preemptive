
class SJF{
    //global variables
    int [] processId;
    int [] arrivalTime;
    int [] burstTime;
    int [] completionTime ;
    int [] turnAroundTime;
    int [] waitingTime;
    int [] readyQueue;
    int [] tempVal  ;
    int time;
    int process;
    double sum;
    
    public static void main(String[] args) {
        
    }

   public SJF(int pID[], int aT[],int bT[],int tempVal[],int cT[], int tAT[],int wT[],int rQ[],int p, int t,double s){
       //set constructor for input to globally set variables
           this.processId = pID;
           this.arrivalTime = aT;
           this.burstTime = bT;
           this.tempVal  = tempVal   ;
           this.completionTime = cT;
           this.turnAroundTime = tAT;
           this.waitingTime = wT;
           this.readyQueue = rQ;
           this.process = p;
           this.time = t;
           this.sum = s;
   }    

   public SJF(){};

   //display content of table
   void displayTable(){
       System.out.println();
       System.out.println("SJF");
       System.out.println("pID\tAT\tBT\tCT\tTAT\tWT");
       System.out.println("--------------------------------------------------");
       for(int i = 0; i<process;i++){
       System.out.println("P" + processId[i] + "\t" + arrivalTime[i] + "\t" + tempVal   [i] +"\t" + completionTime[i]
       + "\t" + turnAroundTime[i] + "\t" + waitingTime[i]);
       System.out.println("--------------------------------------------------");
       }	

       System.out.println("Average Turn-around Time:\t" + String.format("%.2f", computeAverage(turnAroundTime)) + " units");
       System.out.println("Average Waiting Time:\t\t" +String.format("%.2f", computeAverage(waitingTime))+ " units");
       System.out.println();
   }

     //execute Shortest Job First Algorithm
     void getRunningProcess(){
       int completed = 0;
       //will execute until all processes are completed
       for(int i = 0; i < process;i=completed){
           //get all processes thaT arrives aT time = n;
           getReadyQueue();
           //sort ready queue by burst time
           sortBurstTime();
           //if ready queue is empty
           if(readyQueue[0]==999){
               //increase time
               time++;
           }
           //if ready queue is not empty
           else{
               //get the first index of the ready queue, compute the cT,tAT and wT
               computeCompletionTime();
               //once executed, completed integer will increase
               //once the integer completed is equal to number of process, the algorithm will stop
               completed++;
           }
       }
       displayTable();
   }

   
   //get ready queue
   void getReadyQueue(){
       readyQueue= new int [process];
       for(int i = 0; i<process;i++){
            //if process' aT is less than or equal to time, and it's bT is greaTer than 0, add it to Ready Queue
           if(arrivalTime[i]<=time && burstTime[i]>0){
               readyQueue[i] = i;
           }
           else{  
               //else ready queue will be empty
               readyQueue[i] = 999;
           }
       }

       //sort ready queue from lowest to highest using bubblesort algortihm
       for(int i = 0; i<process; i++){
           for(int j=0; j<process-i-1;j++){
               if(readyQueue[j]>readyQueue[j+1]){
                   int tmp = readyQueue[j];
                   readyQueue[j] = readyQueue[j+1];
                   readyQueue[j+1] = tmp;
               }
           }
       }
   }
   //sort ready queue by bubble sort using bubble sort 
   void sortBurstTime(){

       for(int i = 0; i<process-1; i++){
           for(int j=0; j<process-i-1;j++){
                   //if j+1 index of ready queue is 999, ignore
                   //else, do this
                   if(!(readyQueue[j+1]==999)){
                       //if burst time of jth index of ready queue is greaTer than j+1 index, do swap
                       if(tempVal   [readyQueue[j]]>tempVal    [readyQueue[j+1]]){
                           int tmp = readyQueue[j];
                           readyQueue[j] = readyQueue[j+1];
                           readyQueue[j+1] = tmp;
                       }
                   }
               }

       }
   }
   
   //once bT of a process = 0, it will be completed
   //time when bT becomes 0 will be the cT of the process
   void computeCompletionTime(){
       time+=burstTime[readyQueue[0]];
       completionTime[readyQueue[0]] = time;
       turnAroundTime[readyQueue[0]] = completionTime[readyQueue[0]]-arrivalTime[readyQueue[0]];
       waitingTime[readyQueue[0]] = turnAroundTime[readyQueue[0]] - burstTime[readyQueue[0]];
       burstTime[readyQueue[0]] = 0;
   }

   //compute avereage of tAT or wT
   double computeAverage(int array[]){
       sum = 0;
       for(int num: array){
           sum += num;
       }
       return sum/process;
   }
}
