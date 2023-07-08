package g_Exceptions.ExceptionsHandling;
import java.io.*;
public class Serializable_withExceptionHandling {
    public static class myClass implements Serializable{
        int a = 5;
        String b = "Hallo in der Klasse";
        byte[] c = {'e', 'x', 'a', 'm', 'p', 'l', 'e'};
        double d = 8.7;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // ------- Objekt schreiben -------

        System.out.println("UE16 starting up...");
        String text1 = "Hallo Welt";
        String text2 = "Hallö mit \"Ö\"";
        File file = new File("object.dat");
        System.out.println("meine object.dat ist hier: " + file.getAbsolutePath());
        FileOutputStream fileoutputstream = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fileoutputstream);
        oos.writeObject(text1); //--- SCHREIBE STRING
        oos.writeObject((int) 6);// SCHREIBE INT
        // mein Objekt erstellen
        myClass meinObjct = new myClass();
        //mein Objt in Datei schreiben
        oos.writeObject(meinObjct);
        oos.close();
        fileoutputstream.close();

        // ------- Objekt einlesen -------
        FileInputStream fi = new FileInputStream("object.dat");
        ObjectInputStream ois = new ObjectInputStream(fi);
        String a = (String) ois.readObject(); //LESE STRING
        int b = (int) ois.readObject(); //LESE INT

        try {
            int c = (int) ois.readObject(); //LESE INT
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("IRGENDWAS IST SCHIEF GELAUFEN BEIM INT c EINLESEN. Fehlermeldung:"+e.getMessage());
        } finally {
            System.out.println("Hier ist finally.");
            ois.close();
        }
        System.out.println("Erstes Objekt: '" + a + "', zweites Objekt: '" + b + "'");
    }


}
