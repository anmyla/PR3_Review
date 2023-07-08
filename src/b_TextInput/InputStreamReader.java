package b_TextInput;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.Reader;

public class InputStreamReader {
    /*
    An InputStreamReader is a bridge from byte streams to character streams:
    It reads bytes and decodes them into characters using a specified
    charset. The charset that it uses may be specified by name or may
    be given explicitly, or the platform's default charset may be accepted.
     */

    public static void main(String[] args) {
        try  {
            InputStream stream = new FileInputStream("sample.txt");
            Reader reader = new java.io.InputStreamReader(stream);
            int data = reader.read();
            while (data != -1) {
                System.out.print((char) data); //int data will be casted to char
                data = reader.read();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}