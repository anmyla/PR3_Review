package h_Threads.Ex6_Threads_Wait;

public class Main {
    private static volatile boolean running = true;

    public static void main(String[] args) {
        //Create a thread for the COUNTER and run it in the background
        Counter counter1 = new Counter(running);
        Thread counterThread1 = new Thread(counter1);

        counterThread1.start();

        //Create another thread for the COUNTER and run it in the background
        Counter counter3 = new Counter(running);
        Thread counterThread3 = new Thread(counter3);

        counterThread3.start();

        Counter counter4 = new Counter(running);
        Thread counterThread4 = new Thread(counter4);

        counterThread4.start();


        Counter counter2 = new Counter(running);
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

        System.out.println("COUNTER 1 :" + counterThread1.getState());
        System.out.println("COUNTER 2:" + counterThread2.getState());

        System.out.println("\nAll processes are now terminated.");
    }
}
