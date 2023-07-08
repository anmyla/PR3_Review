package d_BinaryInput;

import java.io.*;

public class BinaryInput1_withTextFile {
    public static void main(String[] args) throws IOException  {
        readBinary();
        classSolution();

    }

    public static void readBinary() throws IOException {
        File file = new File("sample.txt");
        FileInputStream inputFile = new FileInputStream(file);
        BufferedInputStream inputStream = new BufferedInputStream(inputFile);

        int byteRead;
        while ((byteRead = inputStream.read()) != -1) {
            // char[] ch = Character.toChars(byteRead);
            // System.out.println(ch);
            // Byte wird in char umgewandelt und ausgegeben.
            System.out.println((char) byteRead);
        }

        // close() gibt die Datei wieder frei.
        inputStream.close();

    }

    public static void classSolution() throws IOException {
        File file = new File("sample.txt");
        // FileInputStream stellt eine Verbindung zur Datei her. Datei wird geöffnet.
        FileInputStream fileInputStream = new FileInputStream(file);
        // Für Optimierung der Performance - BufferedInputStream
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        // read() liefert Byte for Byte aus der Datei. Wenn das Ende erreicht ist, dann liefert die Methode -1 als Ergebnis.
        // While-Schleife liest somit Zeichen um Zeichen aus.
        int byteRead;
        int i=0;
        while ((byteRead = bufferedInputStream.read()) != -1) {
            // char[] ch = Character.toChars(byteRead);
            // System.out.println(ch);
            // Byte wird in char umgewandelt und ausgegeben.
            //System.out.print("Zeichen " + i + ": ");
            System.out.print((int) ((char) byteRead));
            System.out.println("\t'" + (char) byteRead + "'");
            i++;
        }
        // close() gibt die Datei wieder frei.
        bufferedInputStream.close();
    }
}
