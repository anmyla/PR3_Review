package h_Threads.Ex5_Threads_Researched;

public class ConcurrentThreadsExample2 {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new Task1Runnable());
        Thread thread2 = new Thread(new Task2Runnable());

        thread1.start();
        thread2.start();
    }

    static class Task1Runnable implements Runnable {
        @Override
        public void run() {
            System.out.println("Task 1 started.");

            // Perform task-specific operations
            for (int i = 1; i <= 5; i++) {
                System.out.println("Task 1: " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("Task 1 completed.");
        }
    }

    static class Task2Runnable implements Runnable {
        @Override
        public void run() {
            System.out.println("Task 2 started.");

            // Perform task-specific operations
            for (char c = 'A'; c <= 'E'; c++) {
                System.out.println("Task 2: " + c);
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("Task 2 completed.");
        }
    }
}