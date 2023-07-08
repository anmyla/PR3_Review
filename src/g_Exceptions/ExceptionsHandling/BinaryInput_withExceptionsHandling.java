package g_Exceptions.ExceptionsHandling;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class BinaryInput_withExceptionsHandling {
    public static void main(String[] args) {
        File file = new File("test.txt");
        System.out.println("Path to file: " + file.getAbsolutePath());
        // FileInputStream stellt eine Verbindung zur Datei her. Datei wird geöffnet.
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            // Für Optimierung der Performance -> BufferedInputStream
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            // read() liefert Byte for Byte aus der Datei. Wenn das Ende erreicht ist, dann liefert die Methode -1 als Ergebnis.
            // While-Schleife liest somit Zeichen um Zeichen aus.
            int byteRead;
            int i = 0;
            while ((byteRead = bufferedInputStream.read()) != -1) {
                // char[] ch = Character.toChars(byteRead);
                // System.out.println(ch);
                // Byte wird in char umgewandelt und ausgegeben.
                System.out.print("Zeichen " + i + ": ");
                System.out.print((int) ((char) byteRead));
                System.out.println("\t'" + (char) byteRead + "'");
                i++;
            }
            // close() gibt die Datei wieder frei.
            bufferedInputStream.close();
        } catch (IOException e) {
            System.out.println("Fehler, es gab eine IOException: " + e.getMessage());
        }
    }

}