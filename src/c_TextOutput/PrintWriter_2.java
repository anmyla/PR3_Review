package c_TextOutput;

import java.io.FileWriter;
import java.io.PrintWriter;

public class PrintWriter_2 {
        /*
        close()	closes the print writer
        checkError()	checks if there is an error in the writer and returns a boolean result
        append()	appends the specified data to the writer
         */
    public static void main(String[] args) {
        try {
            PrintWriter printWriter = new PrintWriter(new FileWriter("printWriter2.txt"));

            int age = 26;

            printWriter.printf("I am %d years old.", age);
            printWriter.println("I am " + age + " years old.");

            printWriter.flush();

            System.out.println(printWriter.checkError());

            printWriter.close();

        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}

