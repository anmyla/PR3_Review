package h_Threads.Ex3_ThreadsWithSynconizedLock_BankAccount;

public class Demo {
    public static void main(String[] args) {
        Account a1 = new Account (100);
        Account a2 = new Account (200);

        Runnable w1 = new Worker('A', a1, a2);
        Runnable w2 = new Worker('B', a2, a1);

        Thread t1 = new Thread(w1);
        Thread t2 = new Thread(w2);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Account a1 (should have 100): " + a1.getValue());
        System.out.println("Account a2 (should have 200): " + a2.getValue());
    }
}
