package h_Threads.Ex3_ThreadsWithSynconizedLock_BankAccount;

public class Account {
    private double value;

    public Account(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

}
