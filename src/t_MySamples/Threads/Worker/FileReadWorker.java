package t_MySamples.Threads.Worker;

import s_Exercises.Ex3_ClosingExercise.Worker;
import java.io.*;
import java.util.ArrayList;

public class FileReadWorker extends Worker implements Runnable {
    private String path;
    public ArrayList<String> lines;

    public FileReadWorker(String name, String path) {
        super(name);
        this.path = path;
        this.lines = new ArrayList<>();
    }

    @Override
    protected void work() {
        File f = new File("fw_pw1.txt");
        printStarted();
        // Code to read file and populate the 'lines' ArrayList
        try {
            String one_line;
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            while ((one_line = br.readLine()) != null) {
                if (shouldRun == false) {
                    break; // Exit the loop if shouldRun is false
                }
                // Simulating delay
                System.out.println(one_line); // Print each line of the file
                Thread.sleep(3000); // Wait for 3 seconds
                lines.add("Example line 1");// Add example lines to the ArrayList
                lines.add("Example line 2");
                lines.add("Example line 3");
            }
            br.close(); //close the file so that it can be used by others(programs or functions)
        }

        //this is where and how we handle exceptions
        catch (InterruptedException e) {
            //in case of InterruptedException, the exception will
            // be caught by the catch block, and the corresponding stack trace will be printed.
            e.printStackTrace();

            //If FileNotFoundException occurs during the process, the exception will
            // be caught by the catch block, and then a RuntimeException will be thrown
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);

            //If IOException occurs during the process, it will be caught and then a RuntimeException will be thrown
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Print a message when the worker stops
        printStopped();
    }

    @Override
    public void run() {
        work(); // Call the work method when the thread starts
    }
}
