package t_MySamples.TextInputOutput;

import java.io.*;

public class TextOutput {
    public static void main(String[] args) throws IOException {
        writingDataFromAStringToAStringWriter();

        writingDataFromAStringToAFileUsingFileWriter();
        writeDataFromAStringToAFileFOS();
        writeDataFromAStringToAFilePW();

        writeDataFromAPrintWriterToAFile();

        writeDataFromConsoleToAFile();


    }
    public static void writingDataFromAStringToAStringWriter() {
        String data = "This is the text in the string"; // The string to be written to the file

        try {
            // Creates a StringWriter to write characters to an internal string buffer
            java.io.StringWriter stringWriter = new java.io.StringWriter();
            // Writes the content of the 'data' string to the StringWriter
            stringWriter.write(data);
            // Appends additional text to the StringWriter
            stringWriter.append(": append");
            // flush any buffered content to ensure it is written immediately to the file.
            stringWriter.flush();
            // Closes the StringWriter releasing any system resources associated with it.
            stringWriter.close();

            // Prints the content of the StringWriter
            System.out.println("Data of StringWriter: " + stringWriter);

        } catch (Exception e) {
            e.getStackTrace(); // Prints the stack trace if an exception occurs
        }
    }
    public static void writingDataFromAStringToAFileUsingFileWriter() {
        String data = "This is the data in the output file"; //to be written to the file that will be created

        try {
            // Creates a FileWriter that will return a text-oriented stream of the STRING(in this case)
            java.io.FileWriter fileWriter = new java.io.FileWriter("fileWriter.txt"); //where the data will be written(destination)
            //write the content of the String variable(data) to the file(fileWriter.txt).
            fileWriter.write(data);
            // flush any buffered content to ensure it is written immediately to the file.
            fileWriter.flush();
            // Closes the writer and releasing any system resources associated with it and finalizing the writing process.
            fileWriter.close();
            //Information that the process is successful
            System.out.println("File created.");

            //If any IOException occurs during the writing process, the exception will
            // be caught by the catch block, and the corresponding stack trace will be printed.
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeDataFromAStringToAFileFOS() throws IOException { //write Data From A String To A File using fileOutputStream
        String data = "example"; // The string to be written to the file

        //Creates a FileOutputStream to write to the file
        FileOutputStream file = new FileOutputStream("outputStream.txt");
        //Creates an OutputStreamWriter to write characters to the FileOutputStream
        //OutputStreamWriter is a bridge between byte streams and character streams.Convers Characters into bytes
        java.io.OutputStreamWriter outputStreamWriter = new java.io.OutputStreamWriter(file);

        outputStreamWriter.write(data); // Writes the content of the 'data' string to the file
        outputStreamWriter.flush(); // Flushes any buffered characters to the underlying stream
        outputStreamWriter.close(); // Closes the writer and releases any system resources associated with it

        // It is good practice to close the writer to ensure that any remaining data is written and resources are properly released
    }

    public static void writeDataFromAStringToAFilePW() { //write Data From A String To A File using PrintWriter
        try {
            // Creates a PrintWriter object which acts as a bridge
            // between character data and the fileWriter1 for writing text to the file.
            PrintWriter printWriter = new PrintWriter(new FileWriter("printWriter2.txt"));
            int age = 26;

            //write these data to the file
            printWriter.printf("I am %d years old.", age); //this is with format specifiers
            printWriter.println("I am " + age + " years old.");

            //Flushes any buffered content from the printWriter1 to ensure it is written immediately to the file.
            printWriter.flush();

            System.out.println(printWriter.checkError()); //checks if there is an error in the writer and returns a boolean result

            //Closes the printWriter, releasing any system resources associated with it and finalizing the writing process.
            printWriter.close();

            //If any Exception occurs during the writing process, the exception will
            // be caught by the catch block, and the corresponding stack trace will be printed.
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public static void writeDataFromAPrintWriterToAFile() {
        try {
        //Creates a File object representing the file to which the data will be written.
        // In this case, it is named "fw_pw2.txt".
        File file = new File("fw_pw2.txt");
        // Creates a FileWriter object named fileWriter1 with the specified file as the destination for writing
        FileWriter fileWriter1 =  new FileWriter(file, true); //The true parameter indicates that
                        // the writer should append the data to the existing content of the file, rather than overwrite it.

            // Creates a PrintWriter object named printWriter1, which acts as a bridge
        // between character data and the fileWriter1 for writing text to the file.
        PrintWriter printWriter1 = new PrintWriter(fileWriter1);

        //Write the following String to the file
        printWriter1.println("row 1");
        printWriter1.println("row 2");
        printWriter1.println("row 3");


        //Flushes any buffered content from the printWriter1 to ensure it is written immediately to the file.
        printWriter1.flush();

        //Closes the printWriter1, releasing any system resources associated with it and finalizing the writing process.
        printWriter1.close();

        //Prints a message indicating that the process was successful.
        System.out.println("File created successfully!");

         //If any Exception occurs during the writing process, the exception will
            // be caught by the catch block, and then a new (different)Exception will be thrown
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void writeDataFromConsoleToAFile() throws IOException {
        //Creating an instance of InputStreamReader to convert the bytes into characters
        InputStreamReader fileReader = new java.io.InputStreamReader(System.in); // the source of the data to be read is System.in(console)
        // Creates a BufferedReader over the InputStreamReader.
        BufferedReader reader = new BufferedReader(fileReader);
        // Creates a FileWriter object with the specified file as the destination for writing
        java.io.FileWriter fileWriter = new FileWriter("isr_fw_pw.txt");
        // Creates a PrintWriter object which will act as a bridge
        // between character data and the FileWriter for writing text to the file.
        PrintWriter printWriter = new PrintWriter(fileWriter);

        System.out.println("Enter Subject and Grade:"); //Prompt user to enter data
        String line = reader.readLine(); //save the data that was read by the BufferedReader from System.in to a String variable

        while(!line.equals("stop")) { //execute loop while "stop" has not been entered
            printWriter.println(line); //with println(), liness are printed and terminated correctly
            printWriter.flush(); //this makes sure that the buffered data is written
            System.out.println("Enter Subject and Grade:"); //Prompt user to enter data
            line = reader.readLine(); //save the data that was read by the BufferedReader from System.in to a String variable
            if (line.equals("Stop") || line.equals("STop") ||line.equals("STOp") || line.equals("STOP")|| line.equals("stoP") || line.equals("stOP")|| line.equals("sTOP")) {
                line = reader.readLine().toLowerCase();
            }
        }
        //Closes the BufferedReader, releasing any system resources associated with it.
        reader.close();
        // Closes the PrintWriter, releasing any system resources associated with it.
        printWriter.close();
    }
}
