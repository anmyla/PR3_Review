package t_MySamples.Threads.Worker;

public class DemoThreads {
    public static void main(String[] args) {

        //create first Thread--this will print the current time on the console
        Thread timePrintThread = new Thread(new TimePrintWorker("TimePrintWorker"));

        //create second thread-- this will read data from the given file and print it on the console
        Thread fileReadThread = new Thread(new FileReadWorker("FileReadWorker", "fw_pw1.txt"));
        fileReadThread.start(); // Start the fileReadingWorker thread
        timePrintThread.start(); // Start the timePrintWorker thread

        try {
            fileReadThread.join(); // Wait for the file reading to complete
            timePrintThread.join(); // Ask the time print worker to stop
        } catch (InterruptedException e) {
            //in case of InterruptedException, the exception will
            // be caught by the catch block, and the corresponding stack trace will be printed.
            e.printStackTrace();
        }
    }
}