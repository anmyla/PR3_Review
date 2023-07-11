package s_Exercises.Ex3_ClosingExercise;

public class DemoApplication {
    public static void main(String[] args) {
        Thread timePrintThread = new Thread(new TimePrintWorker("TimePrintWorker"));
        Thread fileReadThread = new Thread(new FileReadWorker("FileReadWorker", "test.txt"));

        fileReadThread.start();
        timePrintThread.start();

        try {
            fileReadThread.join(); // Wait for the file reading to complete
            timePrintThread.join(); // Ask the time print worker to stop
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}