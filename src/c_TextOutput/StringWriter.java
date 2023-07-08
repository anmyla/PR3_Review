package c_TextOutput;

public class StringWriter {
    /*
    Methods of StringWriter
        The StringWriter class provides implementations for different methods present in the Writer class.

    write() Method
    write() - writes a single character to the string writer
    write(char[] array) - writes the characters from the specified array to the writer
    write(String data) - writes the specified string to the writer
     */

    public static void main(String[] args) {
        String data = "This is the text in the string";

        try {
            java.io.StringWriter stringWriter = new java.io.StringWriter();
            stringWriter.write(data);
            stringWriter.append(": append");
            stringWriter.flush();
            stringWriter.close();
            System.out.println("Data of StringWriter: "+ stringWriter);
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}