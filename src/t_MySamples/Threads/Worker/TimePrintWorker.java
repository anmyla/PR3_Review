package t_MySamples.Threads.Worker;

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
                    Thread.sleep(1000); // pauses the execution of the thread for 1 sec
                    stopWorker(); //Stop the worker after waiting
                } catch (InterruptedException e) {
                    //in case of InterruptedException, the exception will
                    // be caught by the catch block, and the corresponding stack trace will be printed.
                    e.printStackTrace();
                }
            }
            printStopped(); // Print a message when the worker stops
        }
}
