package t_MySamples.Threads.Worker;

public abstract class Worker {
    protected String name;
    protected boolean shouldRun;

    public Worker(String name) {
        this.name = name;
        shouldRun = true;
    }

    protected abstract void work(); // Abstract method to be implemented by subclasses

    protected void printStarted(){ // Print a message when the worker starts
        System.out.println(name + " is starting.....");
    }

    protected void printStopped(){ // Print a message when the worker stops
        System.out.println(name + " has ended....");
    }

    protected void stopWorker(){ // Set boolean value of shouldRun flag to false
        shouldRun = false;
    }
}
