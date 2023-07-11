package t_MySamples.Threads;

import java.util.Date;

public class TimePrintWorker extends Worker implements Runnable {


    public TimePrintWorker(String name) {
        super(name);
    }

    @Override
    public void run() {
        work(); // Call the abstract method defined in the superclass
    }

    @Override
        protected void work() {
            printStarted(); // Print a message when the worker starts
            while (shouldRun) { // Keep running as long as shouldRun is true
                Date currentTime = new Date(); //New Date object
                System.out.println(currentTime); // Print the current time


                try {
                    Thread.sleep(1000); // Wait for 1 second
                    stopWorker(); //Stop the worker after waiting
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            printStopped(); // Print a message when the worker stops
        }
}
