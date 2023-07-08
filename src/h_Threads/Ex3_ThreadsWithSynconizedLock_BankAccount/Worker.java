package h_Threads.Ex3_ThreadsWithSynconizedLock_BankAccount;

public class Worker implements Runnable{
    private char sign;
    private final int count = 10;
    private final int sleepInterval = 10;

    private static Object accountLock = new Object();

    private Account a1;
    private Account a2;

    public Worker(char sign, Account a1, Account a2) {
        this.sign = sign;
        this.a1 = a1;
        this.a2 = a2;
    }

    @Override
    public void run() {
        synchronized (accountLock) {
            for (int i = 0; i < count; i++) {
                double value1 = a1.getValue();
                System.out.println(sign + " Value of a1 is determined.");

                double value2 = a2.getValue();
                System.out.println(sign + " Value of a2 is determined.");

                a1.setValue(value1 - 10);
                System.out.println(sign + " 10 is withdrawn from a1.");

                a2.setValue(value2 + 10);
                System.out.println(sign + " 10 is added to a2.");

                try {
                    Thread.sleep(sleepInterval);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
        }
    }
}
