package s_Exercises.Ex3_ClosingExercise;

public abstract class Worker {
protected String name;
protected boolean shouldRun;

    public Worker(String name) {
        this.name = name;
        shouldRun = true;
    }

   protected abstract void work();

   protected void printStarted(){
       System.out.println(name + " is starting.....");
    }

    protected void printStopped(){
        System.out.println(name + " has ended....");
    }

    protected void stopWorker(){
        shouldRun = false;
    }
}
