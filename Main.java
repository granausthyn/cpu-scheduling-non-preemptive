import java.util.Scanner;

public class Main {
    static int[] processId, arrivalTime, burstTime, completionTime, turnAroundTime, waitingTime, priority, deadline,
            period, flags, queuePriority, tempPeriod, array, startingTime, readyQueue, runningQueue, count, temp;
    static int time = 0, process = 0, output = 0, lcm = 1, startTime = 0, check = 0, executeAgain;
    static Scanner scan = new Scanner(System.in);
    static String choiceInput, algorithm = "";
    static double sum = 0;

    public static void main(final String args[]) {
        do{
            //get data input from user.
            inputNumberofProcesses();
            inputArrivalTime();
            inputBurstTime();

            //Display the scheduling algorithms[non preemptive]
            displayAlgorithms();

            //Get input from user on what algorithm is to be used and produce output relative to chosen algorithm.
            inputAlgorithm();
            outputAlgorithm();

            System.out.print("Would you like to use the program again?[Y/N]: ");
            choiceInput = scan.next();

            //Program continues to run if user inputs yes[y], otherwise program is terminated. 
            if(choiceInput.equalsIgnoreCase("Y")){
                executeAgain = 1;
                choiceInput = "";
            }else if(choiceInput.equalsIgnoreCase("N")){{
                executeAgain = 0;
                choiceInput = "";
            }
            
        }
    }while(executeAgain==1);
        //Terminate thhe program if user chooses N.
        scan.close();
        System.out.println("Thank you for using our program......\n***Program terminated***"); 
        System.exit(0);

    }

    // display Algorithm Choices
    static void displayAlgorithms() {
        System.out.println("\nChoose CPU Scheduling Algorithm[Non-Preemptive]: ");
        System.out.println("[A] First Come First Serve(FCFS)");
        System.out.println("[B] Shortest Job First(SJF)");
        System.out.println("[C] Priority");
        System.out.println("[D] Deadline");
        System.out.println("[E] Multilevel Queue(MLQ)");
        System.out.println("[F] Exit\n");
    }

    // get user input
    static void inputAlgorithm() {
        System.out.print("Enter Choice: ");
        algorithm = scan.next().toUpperCase();
        // if user input is A-F, proceed with the program
        if (algorithm.equalsIgnoreCase("A") || algorithm.equalsIgnoreCase("B") || algorithm.equalsIgnoreCase("C")
                || algorithm.equalsIgnoreCase("D") || algorithm.equalsIgnoreCase("E")
                || algorithm.equalsIgnoreCase("F")) {
            if (algorithm.equalsIgnoreCase("F")) {
                // if user chooses F, the program will terminate
                System.out.println("Thank you for using our program......\n***Program terminated***");
                System.exit(0);
            }
            // if choiceInput is A-E, proceed with program
        }
        // if user input is not A-F, the method will reiterate
        else {
            inputAlgorithm();
        }

        // check algorithm chosen by the user
        System.out.println();
    }

    static void outputAlgorithm() {
        switch (algorithm) {

            case "A": // if choiceInput = a or A, create an object of FCFS class
                FCFS fcfs = new FCFS(processId, arrivalTime, burstTime, temp, completionTime, turnAroundTime,
                        waitingTime, readyQueue, process, time, sum);
                fcfs.getRunningProcess(); // execute FCFS algorithm
                break;
            case "B": // if choiceInput = b or B, create an object of SJF class

                SJF sjf = new SJF(processId, arrivalTime, burstTime, temp, completionTime, turnAroundTime, waitingTime,
                        readyQueue, process, time, sum);
                sjf.getRunningProcess(); // execute SJF algorithm
                break;
            case "C": // if choiceInput = c or C, create an object of Priority class
                getPriority();// get Priority for each Process

                Priority prio = new Priority(processId, arrivalTime, burstTime, temp, priority, completionTime,
                        turnAroundTime, waitingTime, readyQueue, process, time, sum);
                prio.getRunningProcess();
                break;
            case "D": // if choiceInput = d or D, create an object of EDF class
                getDeadline(); // get Deadline for each Process
                getPeriod(); // get Period for each Process
                EDF edf = new EDF(processId, startingTime, burstTime, deadline, period, completionTime, turnAroundTime,
                        waitingTime, temp, tempPeriod, count, array, readyQueue, time, process, sum, lcm);
                edf.getRunningProcess(); // execute Deadline algorithm
                break;
            case "E": // if choiceInput = e or E, create an object of MLQ class
                System.out.println("MLQ"); // display Queue Choices
                System.out.println("Input Number of Queues:");
                System.out.println("[1] First Come First Serve (FCFS)");
                System.out.println("[2] Shortest Job First (SJF)");
                getProcessQueue(); // get Queue Number for each Process
                MLQ mlq = new MLQ(processId, arrivalTime, burstTime, completionTime, turnAroundTime, waitingTime, flags,
                        queuePriority, startTime, check, process);
                mlq.getRunningProcess(); // execute Multi-level Queue algorithm
                break;
            case "F": // if choiceInput = f pr F, choiceInput will be "N"
                // loop will break
                System.out.println("Exit");
                choiceInput = "N";
                break;
        }
    }

    static void inputNumberofProcesses() {
        System.out.print("Input number of processes [2-9]: ");
        boolean done = true;
        while (done) { // if input is invalid, ask for input again
            if (scan.hasNextInt()) {
                process = scan.nextInt();
                if (process < 2 || process > 9) {
                    inputNumberofProcesses();
                }
                done = false;
            } else {
                System.out.print("ENTER VALID NUMBER FROM 2 TO 9: ");
                scan.next();
                continue;
            }
        }

        // insantiate all needed variables
        processId = new int[process];
        arrivalTime = new int[process];
        burstTime = new int[process];
        deadline = new int[process];
        priority = new int[process];
        count = new int[process];
        period = new int[process];
        array = new int[process];
        flags = new int[process];
        tempPeriod = new int[process];
        queuePriority = new int[process];
        startingTime = new int[process];
        completionTime = new int[process];
        readyQueue = new int[process];
        turnAroundTime = new int[process];
        waitingTime = new int[process];
        temp = new int[process];

        System.out.println();
    }

    static void inputArrivalTime() {

        boolean done = true;
        System.out.println("Input individual arrival time:");

        for (int i = 0; i < process; i++) {
            done = true;
            System.out.print("AT" + (i + 1) + ": ");
            while (done) { // if input is invalid, ask for input again
                if (scan.hasNextInt()) {
                    arrivalTime[i] = scan.nextInt();
                } else {
                    System.out.print("ENTER VALID INPUT FOR AT" + (i + 1) + ": ");
                    scan.next();
                    continue;
                }
                done = false;
            }
        }
        System.out.println();

    }

    static void inputBurstTime() {
        System.out.println("Input individual burst time:");
        boolean done = true;
        for (int i = 0; i < process; i++) { // if input is invalid, ask for input again
            done = true;
            System.out.print("BT" + (i + 1) + ": ");
            while (done) {
                if (scan.hasNextInt()) {
                    burstTime[i] = scan.nextInt();
                } else {
                    System.out.print("ENTER VALID INPUT FOR BT" + (i + 1) + ": ");
                    scan.next();
                    continue;
                }
                done = false;
            }
            processId[i] = i;
        }
        temp = burstTime.clone();
        System.out.println();
    }

    static void getDeadline() {
        System.out.println();
        System.out.println("Input deadline for each process:");
        boolean done = true;
        for (int i = 0; i < process; i++) {
            done = true;
            System.out.print("Deadline " + (i + 1) + ": ");
            while (done) { // if input is invalid, ask for input again
                if (scan.hasNextInt()) {
                    deadline[i] = scan.nextInt();
                    startingTime[i] = 0;
                } else {
                    System.out.print("ENTER VALID INPUT FOR Deadline " + (i + 1) + ": ");
                    scan.next();
                    continue;
                }
                done = false;
            }
        }
        temp = deadline.clone();
        System.out.println();
    }

    static void getPeriod() {
        System.out.println();
        System.out.println("Input period for each process:");
        boolean done = true;
        for (int i = 0; i < process; i++) {
            done = true;
            System.out.print("Period " + (i + 1) + ": ");
            while (done) { // if input is invalid, ask for input again
                if (scan.hasNextInt()) {
                    period[i] = scan.nextInt();
                } else {
                    System.out.print("ENTER VALID INPUT FOR Period " + (i + 1) + ": ");
                    scan.next();
                    continue;
                }
                done = false;
            }
        }
        array = period.clone();
        tempPeriod = period.clone();
        System.out.println();
    }

    static void getPriority() {
        System.out.println();
        System.out.println("Input individual priority number:");
        boolean done = true;
        for (int i = 0; i < process; i++) { // if input is invalid, ask for input again
            done = true;
            System.out.print("PRIO " + (i + 1) + ": ");
            while (done) {
                if (scan.hasNextInt()) {
                    priority[i] = scan.nextInt();
                } else {
                    System.out.print("ENTER VALID INPUT FOR PRIO " + (i + 1) + ": ");
                    scan.next();
                    continue;
                }
                done = false;
            }
        }
        System.out.println();
    }

    static void getProcessQueue() {
        // user input to assign the queue number for each processes
        for (int i = 0; i < process; i++) {
            boolean done = true;
            System.out.print("Enter Process " + (i + 1) + " Queue: ");
            while (done) {// if input is invalid, ask for input again
                if (scan.hasNextInt()) {
                    queuePriority[i] = scan.nextInt();
                    if (queuePriority[i] < 1 || queuePriority[i] > 2) {
                        System.out.println("1 or 2 only!");
                        getProcessQueue();
                    }
                } else {
                    System.out.print("ENTER VALID INPUT FOR Process Queue" + (i + 1) + ": ");
                    scan.next();
                    continue;
                }
                done = false;
            }
        }
        System.out.println();
    }

}