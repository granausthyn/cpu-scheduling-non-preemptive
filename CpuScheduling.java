import java.util.*;

public class CpuScheduling {

    static Scanner sc = new Scanner(System.in);
    
    
    public static void main(String[] args) {
        displayUserOptions();
    }

    public void chooseOption(){
        System.out.print("Choose Algorithm: ");
      //  input = userInput.nextLine();
    }

    static void displayUserOptions(){

        System.out.println("\nChoose CPU Scheduling [Non-Preemptive]Algorithm: ");
        System.out.println("[A] First Come First Serve Scheduling (FCFS)");
        System.out.println("[B] (SJF)");
        System.out.println("[C] Priority");
        System.out.println("[D] Deadline");
        System.out.println("[E] (MLQ)");
        System.out.println("[G] Exit\n");
        
        
    }
}
