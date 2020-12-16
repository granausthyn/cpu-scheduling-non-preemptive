import java.util.*;

public class CpuScheduling {

    static Scanner sc = new Scanner(System.in);
    static String answer, inputAlgorithm = "";

    
    
    public static void main(String[] args) {
        displayUserOptions();
        chooseAlgorithm();
    }

    static void displayUserOptions(){
        System.out.println("\nChoose CPU Scheduling [Non-Preemptive]Algorithm: ");
        System.out.println("[A] First Come First Serve(FCFS)");
        System.out.println("[B] Shortest Job First(SJF)");
        System.out.println("[C] Priority");
        System.out.println("[D] Deadline");
        System.out.println("[E] (MLQ)");
        System.out.println("[F] Exit\n");
        
    }

    //get user input
    static void chooseAlgorithm() {
        System.out.print("Enter Choice: ");
        inputAlgorithm = sc.next().toUpperCase();
        //if user input is A-F, proceed with the program
        if(inputAlgorithm.equalsIgnoreCase("A") || inputAlgorithm.equalsIgnoreCase("B") || inputAlgorithm.equalsIgnoreCase("C") ||
        inputAlgorithm.equalsIgnoreCase("D") || inputAlgorithm.equalsIgnoreCase("E") || inputAlgorithm.equalsIgnoreCase("F")){
            if(inputAlgorithm.equalsIgnoreCase("F")){
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
        switch (inputAlgorithm) {
            

            case "A": //if answer = a or A, create an object of FCFS class
                System.out.println("First Come First Serve");
                break;
            case "B":  //if answer = b or B, create an object of SJF class
            System.out.println("Shortest Job First");
            
                break;
            case "C": //if answer = c or C, create an object of Priority class
            System.out.println("Priority");
                break;
            case "D": //if answer = d or D, create an object of EDF class
            System.out.println("Deadline");
                break;
            case "E": //if answer = e or E, create an object of MLQ class
            System.out.println("Multi Level Queing");
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
