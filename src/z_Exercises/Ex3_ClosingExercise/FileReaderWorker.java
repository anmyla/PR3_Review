package z_Exercises.Ex3_ClosingExercise;

import java.io.*;
import java.util.ArrayList;

class FileReadWorker extends Worker implements Runnable {
    private String path;
    public ArrayList<String> lines;

    public FileReadWorker(String name, String path) {
        super(name);
        this.path = path;
        this.lines = new ArrayList<>();
    }

    @Override
    protected void work() {
        File f = new File("test.txt");
        printStarted();
        // Code to read file and populate the 'lines' ArrayList
        try {
            String one_line;
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            while ((one_line = br.readLine()) != null) {
                if (shouldRun == false) {
                    break;
                }
                // Simulating delay
                System.out.println(one_line);
                Thread.sleep(3000);
                lines.add("Example line 1");
                lines.add("Example line 2");
                lines.add("Example line 3");
            }
            br.close();
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
        work();
    }
}
