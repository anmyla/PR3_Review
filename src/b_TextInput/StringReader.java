package b_TextInput;

public class StringReader {
    /*
    Java StringReader class is a character stream with
    string as a source. It takes an input string and
    changes it into character stream. It inherits Reader class.

    In StringReader class, system resources like network
    sockets and files are not used, therefore closing the
    StringReader is not necessary.
    */

    public static void main(String[] args) throws Exception {
        String srg = "Hello Java";
        java.io.StringReader stringReader = new java.io.StringReader(srg);
        int c = 0;
        while ((c = stringReader.read()) != -1) {
            System.out.println((char) c);
        }
    }
}