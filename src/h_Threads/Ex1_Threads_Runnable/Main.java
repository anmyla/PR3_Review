package h_Threads.Ex1_Threads_Runnable;

public class Main {
    public static void main(String[] args) {

        System.out.println("Main thread ID and name: " + Thread.currentThread().getId() + " " + Thread.currentThread().getName());

        Person p1 = new Person("Hansi");
        Person p2 = new Person("Duchess of Carrotonia");

        Thread t1 = new Thread(p1);
        Thread t2 = new Thread(p2);

        t1.start();
        t2.start();
        System.out.println("main() both Threads started");

        try {
            t1.join();
            t2.join();
        } catch ( InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("main() both Threads ends");
    }
}
