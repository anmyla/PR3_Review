package b_TextInput;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReader_CharByChar {
public static void main(String[] args) throws IOException {
        // öffnet die Datei test.txt
        File file = new File("sample.txt");
        // liefert einen textorientierten Stream der Datei zurück
        FileReader fileReader = new FileReader(file);
        // legt einen BufferedReader über den FileReader. Somit kann komfortabler auf die Datei zugegriffen werden.
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        // Zeichen für Zeichen wird eingelesen.
        // Ist das Dateiende erreicht, so wird -1 zurückgeliefert.
        int c;
        while ((c = bufferedReader.read()) != -1) {
        // int muss auf char gecastet werden, um somit Buchstaben zu erhalten. (Sonst nur Zahlen)
        char character = (char) c;
        System.out.println("int: " + c + " -> char: " + character);
        }
        // bufferedReader wird geschlossen
        bufferedReader.close();
        }

        }



