package b_TextInput;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReader {

        public static void main(String[] args) throws IOException {
            // öffnet die Datei sample.txt
            File file = new File("umlaut.txt");
            // liefert einen textorientierten Stream der Datei zurück
            FileReader fileReader = new FileReader(file);
            // legt einen BufferedReader über den FileReader.
            // Somit kann komfortabler/effizenter auf die Datei zugegriffen werden.
            java.io.BufferedReader bufferedReader1 = new java.io.BufferedReader(fileReader);

            // ODER
            java.io.BufferedReader br2 = new java.io.BufferedReader(new FileReader(new File("umlaut.txt")));
            java.io.BufferedReader br3 = new java.io.BufferedReader(new FileReader("umlaut.txt"));
            // Zeile für Zeile wird eingelesen. Ist das Dateiende erreicht, so wird null zurückgeliefert.
            String line;
            while ((line = bufferedReader1.readLine()) != null) {
                System.out.println(line);
            }
            // bufferedReader wird geschlossen
            bufferedReader1.close();
        }
    }
