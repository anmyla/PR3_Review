package h_Threads.Ex4_Threads_Synchronize;

public class Main {
    private static volatile boolean running = true;

    public static void main(String[] args) {
        //Create a thread for the CLOCK and run it in the background
        Clock clock1 = new Clock(running);
        Thread clockThread1 = new Thread(clock1);


        Clock clock2 = new Clock(running);
        Thread clockThread2 = new Thread(clock2);

        //Check threads' status
        System.out.println("clock1 state:" + clockThread1.getState());
        System.out.println("clock2 state:" + clockThread2.getState());
        System.out.println();

        clockThread1.start();
        System.out.println("Started clock1....");
        System.out.println("clock1 state:" + clockThread1.getState());


        clockThread2.start();
        System.out.println("Started clock1....");
        System.out.println("clock2 state:" + clockThread2.getState());
        System.out.println();

        //Check threads' status
        System.out.println("clock1 state:" + clockThread1.getState());
        System.out.println("clock2 state:" + clockThread2.getState());
        System.out.println();


        //Wait for the background threads to finish.
        try {
            clockThread1.join();
            clockThread2.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println();

        System.out.println("clock state:" + clockThread1.getState());
        System.out.println("timer state:" + clockThread2.getState());

        System.out.println("\nAll processes are now terminated.");
    }
}
