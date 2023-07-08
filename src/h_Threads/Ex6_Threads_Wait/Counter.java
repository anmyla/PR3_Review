package h_Threads.Ex6_Threads_Wait;

public class Counter implements Runnable {
    private static int count;
    private boolean isRunning;
    private static Object lock = new Object();

    public Counter(boolean running) {
        this.isRunning = running;
    }

    @Override
    public void run() {
        while (isRunning) {
            try {
                Thread.sleep(500); // Wait
            } catch (InterruptedException e) {
                // React to an interruption
                e.printStackTrace();
            }
            synchronized (lock) {
                if (count > 20) {
                    isRunning = false;
                    break;
                }
                    System.out.println(Thread.currentThread().getName() + ": " + count);
                    count++;
                }
            }

        }
    }