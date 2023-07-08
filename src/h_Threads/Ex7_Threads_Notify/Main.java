package h_Threads.Ex7_Threads_Notify;

public class Main {
    private static volatile boolean running = true;

    public static void main(String[] args) {
        //Create a thread for the COUNTER and run it in the background
        Count counter1 = new Count();
        Thread counterThread1 = new Thread(counter1);

        counterThread1.start();

        //Create another thread for the COUNTER and run it in the background
        Count counter2 = new Count();
        Thread counterThread2 = new Thread(counter2);

        counterThread2.start();



        //Wait for the background threads to finish.
        try {
            counterThread1.join();
            counterThread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println();

        System.out.println("Counter 1 :" + counterThread1.getState());
        System.out.println("Counter 2 :" + counterThread2.getState());
        System.out.println("\nCOUNTER : " +Count.getCount());

        System.out.println("\nAll processes are now terminated.");
    }
}
