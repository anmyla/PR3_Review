package g_Exceptions.Finally;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public final class CatchInsideFinally {

    public static void main(String... args) {
        catchInsideFinally("sample.txt");
    }

    private static void catchInsideFinally(String fileName) {
        //Declared here to be visible from finally block
        BufferedReader reader = null;
        try {
            //if this line fails, finally will be executed, and reader will be null
            reader = new BufferedReader(new FileReader(fileName));
            String line = null;
            while ((line = reader.readLine()) != null) {
                //process the line...
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                //need to check for null
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}