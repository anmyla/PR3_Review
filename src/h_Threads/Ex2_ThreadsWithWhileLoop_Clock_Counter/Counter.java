package h_Threads.Ex2_ThreadsWithWhileLoop_Clock_Counter;

public class Counter implements Runnable {
    private boolean isRunning;

    public Counter(boolean running) {
        this.isRunning = running;
    }

    public void requestShutDown() {
        isRunning = false;
    }

    @Override
    public void run() {
        int seconds = 0;

        while (isRunning) {
            System.out.println("Elapsed time: " + seconds + " seconds");

            try {
                Thread.sleep(1000); // Wait 1 sec
            } catch (InterruptedException e) {
                // React to an interruption
                e.printStackTrace();
            }

            seconds++;
        }
    }
}