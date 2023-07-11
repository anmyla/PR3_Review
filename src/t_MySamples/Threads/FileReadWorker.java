package t_MySamples.Threads;

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
        catch (InterruptedException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        printStopped();
    }

    @Override
    public void run() {
        work(); // Call the work method when the thread starts
    }
}
