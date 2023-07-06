package TextInput;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class File_FileReader_BufferedReader_C {
    public static void main(String[] args) throws IOException {
        // öffnet die Datei test.txt
        File file = new File("k.txt");
        // liefert einen textorientierten Stream der Datei zurück
        FileReader fileReader = new FileReader(file);
        // legt einen BufferedReader über den FileReader.
        // Somit kann komfortabler/effizenter auf die Datei zugegriffen werden.
        BufferedReader bufferedReader1 = new BufferedReader(fileReader);

        // ODER
        BufferedReader br2 = new BufferedReader(new FileReader(new File("k.txt")));
        BufferedReader br3 = new BufferedReader(new FileReader("k.txt"));
        // Zeile für Zeile wird eingelesen. Ist das Dateiende erreicht, so wird null zurückgeliefert.
        String line;
        while ((line = bufferedReader1.readLine()) != null) {
            System.out.println(line);
        }
        // bufferedReader wird geschlossen
        bufferedReader1.close();
    }
}
