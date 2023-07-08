package h_Threads.Ex7_Threads_Notify;

public class Count implements Runnable {
    private static int count;

    private static Object lock = new Object();


    public static int getCount() {
        return count;
    }

    @Override
    public void run() {
        synchronized (lock) {
            while (count < 20) {
                count++;
                System.out.println(Thread.currentThread().getName() + ": " + count);
                lock.notify(); // Notify other thread to proceed
                try {
                    lock.wait(); // Wait for notification from other thread
                    Thread.sleep(20);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.notify();
            }
        }
    }
}

/*
public class Count implements Runnable {
    private static int count;
    private boolean isRunning;
    private static Object lock = new Object();

    public Count(boolean running) {
        this.isRunning = running;
    }

    @Override
    public void run() {
        while (isRunning) {
            synchronized (lock) {
                try {
                    if (count > 20) {
                        isRunning = false;
                        break;
                    }
                    System.out.println(Thread.currentThread().getName() + ": " + count);
                    count++;
                    lock.notify(); // Notify other thread to proceed
                    lock.wait(); // Wait for notification from other thread
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        synchronized (lock) {
            lock.notify(); // Notify other thread to exit
        }
    }
}

 */