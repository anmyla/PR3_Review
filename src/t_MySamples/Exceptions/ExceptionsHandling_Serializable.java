package t_MySamples.Exceptions;

import java.io.*;

//Serialization is the process of converting an object's state into a byte stream,
// which can be stored in a file or sent over a network, and later deserialized to recreate the object's state.
//The Serializable interface acts as a marker interface, meaning it does not declare any methods or fields.
// Instead, it serves as a flag to indicate that an object of a class implementing Serializable can be serialized.
public class ExceptionsHandling_Serializable {
    public static class myClass implements Serializable {
        int a = 5;
        String b = "Hallo in der Klasse";
        byte[] c = {'e', 'x', 'a', 'm', 'p', 'l', 'e'};
        double d = 8.7;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("Application starting up...");

        // Initialize some text variables
        String text1 = "Hallo Welt";
        String text2 = "Hallö mit \"Ö\"";  //String with special characters

        // Create a File object to represent the file "object.dat"
        File file = new File("object.dat");
        System.out.println("meine object.dat ist hier: " + file.getAbsolutePath()); //prints absolute location of the file

        // Create a FileOutputStream to write to the file
        FileOutputStream fileoutputstream = new FileOutputStream(file);

        // Create an ObjectOutputStream to write Java objects to the FileOutputStream
        ObjectOutputStream oos = new ObjectOutputStream(fileoutputstream);

        // Write objects to the ObjectOutputStream
        oos.writeObject(text1); // Write the string "Hallo Welt"
        oos.writeObject((int) 6); // Write the integer value 6

        // Create an instance of the custom class myClass
        myClass meinObjct = new myClass();
        oos.writeObject(meinObjct); // Write the myClass object to the ObjectOutputStream

        // Close the streams
        oos.close();
        fileoutputstream.close();

        // Read the objects from the file

        // Create a FileInputStream to read from the file
        FileInputStream fi = new FileInputStream("object.dat");
        // Create an ObjectInputStream to read Java objects from the FileInputStream
        ObjectInputStream ois = new ObjectInputStream(fi);

        // Read the first object as a string
        String a = (String) ois.readObject();
        // Read the second object as an integer
        int b = (int) ois.readObject();

        try {
            // Attempt to read the third object as an integer
            int c = (int) ois.readObject();
        } catch (Exception e) {
            // Catch any exceptions that occur during reading
            System.out.println(e.getMessage());
            System.out.println("IRGENDWAS IST SCHIEF GELAUFEN BEIM INT c EINLESEN. Fehlermeldung:" + e.getMessage());
        } finally {
            // The code in the finally block will always execute no matter if there is an exception or not
            System.out.println("Hier ist finally.");
            ois.close();
        }

        // Print the values of the read objects
        System.out.println("Erstes Objekt: '" + a + "', zweites Objekt: '" + b + "'");
    }
}
