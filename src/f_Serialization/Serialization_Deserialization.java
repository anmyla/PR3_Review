package f_Serialization;


import java.io.*;

/*In Java, serialization refers to the process of converting an object
into a byte stream, which can be written to a file or transferred over
a network. This allows the object to be stored persistently or transmitted
between different Java Virtual Machines (JVMs).

The serialized object can be saved to a file using ObjectOutputStream
and later restored back into an object using ObjectInputStream. The serialization
process preserves the state of the object, including its data and the structure
of the object graph (i.e., relationships with other objects).*/
public class Serialization_Deserialization {
    public static void main(String[] args) throws IOException {

        System.out.println("Program starting up......");
        serialize();
        deserialize();

    }

    public static void serialize() throws IOException {
        String text = "Hallo Welt";
        File file = new File("object.dat"); //create a new file
        System.out.println("Mein Objekt ist hier: " + file.getAbsolutePath()); //prints out location/path of file
        FileOutputStream fileOut = new FileOutputStream(file); //this will set "file" as the location where the data is outputted
        ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
        objectOut.writeObject(text); //this will write the string data named "text" to the file
        objectOut.writeObject(text);
        objectOut.close();
        fileOut.close();
        System.out.println("Objekt wurde erfolgreich serialisiert.");
    }


    public static class myClass implements Serializable { //here we implement serializable
        int a = 5;
        String b = "Hallo in der Klasse";
        byte [] c = {'a', 'b', 'c', 'd', 'e'};
        double d = 8.7;
    }

    public static void serializeMySolution() throws IOException {
        String text = "Hallo Welt";
        File file = new File("object.dat");
        System.out.println("Mein Objekt ist hier: " + file.getAbsolutePath());
        FileOutputStream fileOut = new FileOutputStream(file);
        ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
        objectOut.writeObject(text);
        objectOut.writeObject(text);
        //mein Objekt erstellen
        myClass meinObjekt = new myClass();
        //mein Object in datei schreiben
        objectOut.writeObject(meinObjekt);
        objectOut.close();
        fileOut.close();
        System.out.println("Objekt wurde erfolgreich serialisiert.");
    }

    public static void deserialize() {
        // Deserialized
        try { // try, catch, finally helps to separate the program code from program error code.
            FileInputStream fileIn = new FileInputStream("object.dat");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            String deserializedText = (String) objectIn.readObject();
            objectIn.close();
            fileIn.close();
            System.out.println("Objekt wurde erfolgreich deserialisiert:");
            System.out.println(deserializedText);

        } catch (IOException | ClassNotFoundException e) { // "Exception" will catch all exceptions. "IOException", "ClassExcep.." are subclasses
            e.printStackTrace();
            System.out.println(" Error Message: " + e.getMessage()); //print out the error message
        } finally {
            System.out.println("this party will always run with or without exception");
        }
    }
}
