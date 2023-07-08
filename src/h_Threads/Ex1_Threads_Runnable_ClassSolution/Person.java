package h_Threads.Ex1_Threads_Runnable_ClassSolution;

public class Person implements Runnable {

    private String name;
    boolean isRunning = true;


    public Person (String name) {
        this.name = name;
        System.out.println("Contructor of Class 'Person': \"" + name + "\" created.");
    }

    public void requestShutDown() {
        isRunning = false;
    }

    @Override
    public void run() {
        System.out.println("Person Class ('" + name + "'), called the function run(). ");
        for (int i = 0; i < 10; i++) {
            System.out.println(name + " " + Thread.currentThread().getName() + " " + Thread.currentThread().getId() + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if(isRunning == false) {
                break;
            }
        }

        System.out.println(Thread.currentThread().getName() + " has completed the task.");

    }
}
