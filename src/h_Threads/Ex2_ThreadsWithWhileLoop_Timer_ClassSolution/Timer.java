package h_Threads.Ex2_ThreadsWithWhileLoop_Timer_ClassSolution;

public class Timer implements Runnable {
    private boolean running;

    public Timer(boolean running) {
        this.running = running;
    }

    public void requestShutDown() {
        running = false;
    }

    @Override
    public void run() {
        int seconds = 0;

        while (running) {
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