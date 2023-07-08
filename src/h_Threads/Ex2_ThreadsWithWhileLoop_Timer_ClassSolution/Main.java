package h_Threads.Ex2_ThreadsWithWhileLoop_Timer_ClassSolution;/*package Day6.Exercise1ClassSolution;
import Day6.Class2.ConsoleHelper;

public class Main {
    private static volatile boolean running = true;

    public static void main(String[] args) {
        //Create a thread for the CLOCK and run it in the background
        Worker clock1 = new Worker(running);
        Thread clockThread1 = new Thread(clock1);

        clockThread1.start();

        //Create a thread for the TIMER and run it in the background
        Timer timer1= new Timer(running);
        Thread timerThread1 = new Thread(timer1);

        timerThread1.start();

        //Wait on an input to terminate the process
        System.out.println("\n \nPress ENTER to terminate the process. \n \n");

        //Set RUNNING to stop the background threads.
        if (ConsoleHelper.readLine() != null)  {
            clock1.requestShutDown();
            System.out.println("clock state:" + clockThread1.getState() + " you terminated this thread.");
            System.out.println("timer state:" + timerThread1.getState());
        }

        if (ConsoleHelper.readLine() != null)  {
            timer1.requestShutDown();
            System.out.println("clock state:" + clockThread1.getState());
            System.out.println("timer state:" + timerThread1.getState() + " you terminated this thread.");
        }


        //Wait for the background threads to finish.
        try {
            clockThread1.join();
            timerThread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println();

        System.out.println("clock state:" + clockThread1.getState());
        System.out.println("timer state:" + timerThread1.getState());

        System.out.println("\nAll processes are now terminated.");
    }
} */