package TextInput;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class File_FIleReader_BufferedReader {
        public static void main(String[] args) throws IOException {

//        readAFileGoogleSolution();
            readAFileMySolution();
//        readAFileClassroomSolution();

        }
        public static void readAFileGoogleSolution() { //googled method
            String filePath = "faust.txt"; // file path
            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException e) {
                System.err.println("Error reading the file: " + e.getMessage());
            }
        }
        public static void readAFileMySolution() throws IOException { // own program
            //With Scanner and  "(Paths.get(PATH))", the content will be read called and read
            Scanner someText = new Scanner(Paths.get("test.txt"));
            String nextLine = someText.nextLine();
            do {
                System.out.println(nextLine);
                nextLine = someText.nextLine();
            } while (nextLine != null);

        }

        public static void readAFileClassroomSolution() throws IOException {
//        classroom method
            File file = new File("faust.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader reader = new BufferedReader(fileReader);

            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                line = reader.readLine();
            }
            reader.close();
        }
    }
