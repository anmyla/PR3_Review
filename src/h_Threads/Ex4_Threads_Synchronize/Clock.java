package h_Threads.Ex4_Threads_Synchronize;

import java.util.Date;

public class Clock implements Runnable {
    private boolean running;

    private int count = 10;
    private static Object lock = new Object();

    public Clock(boolean running) {
        this.running = running;
    }


    public void requestShutDown() {
        running = false;
    }

    @Override
    public void run() {
        synchronized (lock) {  //Critical Section
            for (int i = 0; i < count; i++) {
                // Get the current time
                Date currentTime = new Date();

                // Get the number of CPUs
                int numCPUs = Runtime.getRuntime().availableProcessors();

                // Get the amount of free memory
                long freeMemory = Runtime.getRuntime().freeMemory();

                // Print the information

                System.out.print(Thread.currentThread().getName() + " [");
                System.out.print(currentTime.toString());
                System.out.print(", CPUS: ");
                System.out.print(numCPUs);
                System.out.print(", FreeMem: ");
                System.out.print(freeMemory);
                System.out.print("]");
                System.out.println();

                try {
                    Thread.sleep(500); // if the program does not have enough time to wait, the output on the console is chaotic
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}