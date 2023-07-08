package h_Threads.Ex2_ThreadsWithWhileLoop_Timer_ClassSolution;
import java.util.Date;
public class Worker implements Runnable {
    private boolean isRunning;

    public Worker(boolean running) {
    }

    public void requestShutDown() {
        isRunning = false;
    }
    @Override
    public void run() {
        System.out.println("Thread of Worker" + Thread.currentThread().getName());
        while (isRunning) {
            // Return the actual current time
            Date currentTime = new Date();
            System.out.println("Current Time: " + currentTime.toString());

            try {
                Thread.sleep(1000); // Wait 1 second
            } catch (InterruptedException e) {
                // React to an interruption
                e.printStackTrace();
            }
        }
    }
}