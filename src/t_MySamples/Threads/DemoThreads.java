package t_MySamples.Threads;

public class DemoThreads {
    public static void main(String[] args) {

        //create first Thread--this will print the current time on the console
        Thread timePrintThread = new Thread(new TimePrintWorker("TimePrintWorker"));

        //create second thread-- this will read data from the given file and print it on the console
        Thread fileReadThread = new Thread(new FileReadWorker("FileReadWorker", "fw_pw1.txt"));
        fileReadThread.start(); // Start the file reading worker thread
        timePrintThread.start(); // Start the time print worker thread

        try {
            fileReadThread.join(); // Wait for the file reading to complete
            timePrintThread.join(); // Ask the time print worker to stop
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}