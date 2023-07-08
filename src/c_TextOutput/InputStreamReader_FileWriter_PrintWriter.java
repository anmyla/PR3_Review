package c_TextOutput;
import java.io.*;
import java.io.FileWriter;

public class InputStreamReader_FileWriter_PrintWriter {
    public static void main(String[] args) throws IOException {
        inputSaveToFile();
    }

    public static void inputSaveToFile() throws IOException {
        InputStreamReader fileReader = new java.io.InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(fileReader);
        java.io.FileWriter fileWriter = new FileWriter("isr_fw_pw.txt");
        PrintWriter printWriter = new PrintWriter(fileWriter);

        System.out.println("Enter Subject and Grade:");
        String line = reader.readLine();

        while(!line.equals("stop")) {
            printWriter.println(line);
            printWriter.flush();
            System.out.println("Enter Subject and Grade:");
            line = reader.readLine();
            if (line.equals("Stop") || line.equals("STop") ||line.equals("STOp") || line.equals("STOP")|| line.equals("stoP") || line.equals("stOP")|| line.equals("sTOP")) {
                line = reader.readLine().toLowerCase();
            }
        }
        reader.close();
        printWriter.close();
    }
}
