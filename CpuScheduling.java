import java.util.*;
// DITO AKO NAG EEXPERIMENT NG CODES AND TRIAL HEHE
public class CpuScheduling {

    static Scanner sc = new Scanner(System.in);
    static String answer, inputAlgorithm = "",tryAgainInput = "";
    static int tryAgainChoice;
    static boolean tryAgainValue;

    
    
    public static void main(String[] args) {

        do
        {
            displayUserOptions();
            chooseAlgorithm();
        
           System.out.print("Would you like run the choices again?[Y/N]: ");
           tryAgainInput = sc.next();

           if(tryAgainInput.equalsIgnoreCase("y")){
            tryAgainChoice = 1;
           }else{
            tryAgainChoice = 0;
           }
        
        }
        while(tryAgainChoice==1);
        System.out.println("Thank you for using our program......\n***Program terminated***"); 

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

        boolean isChoice = false;
        //validate user input to enter correct option. system will loop if user input does not match the given choices.

        do{
            System.out.print("Enter Choice: ");
            inputAlgorithm = sc.next().toUpperCase();
            //if user input is A-F, proceed with the program
            if(inputAlgorithm.equalsIgnoreCase("A") || inputAlgorithm.equalsIgnoreCase("B") || inputAlgorithm.equalsIgnoreCase("C") ||
            inputAlgorithm.equalsIgnoreCase("D") || inputAlgorithm.equalsIgnoreCase("E") || inputAlgorithm.equalsIgnoreCase("F")){
                if(inputAlgorithm.equalsIgnoreCase("F")){
                    //if user chooses F, the program will terminate
                    System.out.println("Thank you for using our program......\n***Program terminated***");
                    System.exit(0);
                }
                //if answer is A-E, proceed with program
                isChoice = true;
            }
            //if user input is not A-F, the method will reiterate
            else{
                isChoice  = false;
                
            }
    
        }while(isChoice == false);
        
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
