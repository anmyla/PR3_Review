package b_TextInput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputStreamReader_BufferedReader {
    /*
    Schreiben Sie ein Programm, das zeilenweise Tastatureingaben
    auf die Konsole schreibt, bis das Wort „STOP“ eingegeben wird.
    Verwenden Sie dazu den InputStream System.in
    Verwenden Sie weiters die Klassen: InputStreamReader und BufferedReader
     */

    public static void main(String[] args) throws IOException {


        // Ready to receive user Input
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);

        // legt einen BufferedReader über den InputStreamReader.
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        // Zeile für Zeile wird eingelesen.
        String line;
        while (!(line = bufferedReader.readLine()).equals("STOP")) {
            System.out.println(line);
        }

        // BR wird wird geschlossen
        bufferedReader.close();
        // Information, dass das Programm vorbei ist.
        System.out.println("Closed");

        System.out.println("first method done, and this second one will not run because reader.closed()");
        readAFileTillSTOP();

    }


    public static void readAFileTillSTOP() throws IOException {
        InputStreamReader fileReader = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(fileReader);

        String line;
        while(!(line = reader.readLine()).equals("stop")) {
            System.out.println(line);
            line = reader.readLine();
            if (line.equals("Stop") || line.equals("STop") ||line.equals("STOp") || line.equals("STOP")|| line.equals("stoP") || line.equals("stOP")|| line.equals("sTOP")) {
                line = reader.readLine().toLowerCase();
            }
        }
        reader.close();
    }
}
