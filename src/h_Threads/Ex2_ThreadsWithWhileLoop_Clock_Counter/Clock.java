package h_Threads.Ex2_ThreadsWithWhileLoop_Clock_Counter;
import java.util.Date;
public class Clock implements Runnable {
    private boolean running;

    public Clock(boolean running) {
        this.running = running;
    }

    public void requestShutDown() {
        running = false;
    }
    @Override
    public void run() {
        while (running) {
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