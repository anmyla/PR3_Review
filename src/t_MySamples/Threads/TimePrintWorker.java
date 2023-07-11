package t_MySamples.Threads;

import java.util.Date;

public class TimePrintWorker extends Worker implements Runnable {


    public TimePrintWorker(String name) {
        super(name);
    }

    @Override
    public void run() {
        work();
    }

    @Override
        protected void work() {
            printStarted();
            while (shouldRun) {
                Date currentTime = new Date();
                System.out.println(currentTime);

                try {
                    Thread.sleep(1000); // Wait for 1 second
                    stopWorker();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            printStopped();
        }
}
