import java.util.*;

public class CpuScheduling {

    static Scanner sc = new Scanner(System.in);
    static String answer, algorithm = "";

    
    
    public static void main(String[] args) {
        displayUserOptions();
    }

    static void displayUserOptions(){
        System.out.println("\nChoose CPU Scheduling [Non-Preemptive]Algorithm: ");
        System.out.println("[A] First Come First Serve Scheduling (FCFS)");
        System.out.println("[B] Shortest Job First(SJF)");
        System.out.println("[C] Priority");
        System.out.println("[D] Deadline");
        System.out.println("[E] (MLQ)");
        System.out.println("[G] Exit\n");
        
    }

    //get user input
    static void chooseAlgorithm() {
        System.out.print("Enter Choice: ");
        algorithm = sc.next().toUpperCase();
        //if user input is A-F, proceed with the program
        if(algorithm.equalsIgnoreCase("A") || algorithm.equalsIgnoreCase("B") || algorithm.equalsIgnoreCase("C") ||
        algorithm.equalsIgnoreCase("D") || algorithm.equalsIgnoreCase("E") || algorithm.equalsIgnoreCase("F")){
            if(algorithm.equalsIgnoreCase("F")){
                //if user chooses F, the program will terminate
                System.out.println("Terminating Program.........");
                System.exit(0);
            }
            //if answer is A-E, proceed with program
        }
        //if user input is not A-F, the method will reiterate
        else{
            chooseAlgorithm();
        }

        //check algorithm chosen by the user
        switch (algorithm) {
            

            case "A": //if answer = a or A, create an object of FCFS class
               
                break;
            case "B":  //if answer = b or B, create an object of SJF class

               
                break;
            case "C": //if answer = c or C, create an object of Priority class
               
                break;
            case "D": //if answer = d or D, create an object of EDF class
               
                break;
            case "E": //if answer = e or E, create an object of MLQ class
               
                break;
            case "F": //if answer = f pr F, answer will be "N"
            //loop will break
                System.out.println("Exit");
                answer = "N";
                break;
        }
        System.out.println();
    }


}
