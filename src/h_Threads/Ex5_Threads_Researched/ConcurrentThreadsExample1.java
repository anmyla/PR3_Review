package h_Threads.Ex5_Threads_Researched;

public class ConcurrentThreadsExample1 { // main class
    public static void main(String[] args) {
        Thread thread1 = new Thread(new MyRunnable("Thread 1")); // creating an instance of the Object (thread)
        Thread thread2 = new Thread(new MyRunnable("Thread 2"));

        thread1.start(); // thread just run when .start() is called;
        thread2.start();
    }

    static class MyRunnable implements Runnable { // Object Class implements Runnable
        private final String threadName;

        public MyRunnable(String threadName) {
            this.threadName = threadName;
        }

        @Override
        public void run() {
            System.out.println("Thread " + threadName + " is running.");

            try {
                for (int i = 1; i <= 5; i++) {
                    System.out.println("Thread " + threadName + ": " + i);
                    Thread.sleep(1000); // Simulate some work
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Thread " + threadName + " has finished.");
        }
    }
}