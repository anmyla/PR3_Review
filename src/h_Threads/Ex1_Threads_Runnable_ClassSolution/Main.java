package h_Threads.Ex1_Threads_Runnable_ClassSolution;

public class Main {
    private static boolean isRunning;

    public static void main(String[] args) {

        System.out.println("Main thread ID and name: " + Thread.currentThread().getId() + " " + Thread.currentThread().getName());

        Person p1 = new Person("Hansi");
        Person p2 = new Person("Duchess of Carrotonia");

        Thread t1 = new Thread(p1);
        Thread t2 = new Thread(p2);

        t1.start();
        t2.start();
        System.out.println("main() both Threads started");

        p2.requestShutDown();

        System.out.println(t1.getState());
        System.out.println(t2.getState());

        if (ConsoleHelper.readLine() != null) {
            p1.requestShutDown();
            System.out.println("main() t1 state:" + t1.getState());
            System.out.println("main() t2 state:" + t2.getState());
        }

        if (ConsoleHelper.readLine() != null ) {
            p2.requestShutDown();
            System.out.println("main() t1 state:" + t1.getState());
            System.out.println("main() t2 state:" + t2.getState());
        }

        try {
            t1.join();
            t2.join();
        } catch ( InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("main() both Threads ends");
    }
}
