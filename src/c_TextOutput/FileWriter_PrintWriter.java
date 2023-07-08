package c_TextOutput;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileWriter_PrintWriter {
        public static void main(String[] args) throws IOException {
            writeInFile();
            writeInFileClassRoomSolution();
        }

        public static void writeInFile() throws IOException {
            java.io.FileWriter fileWriter = new java.io.FileWriter("fw_pw1.txt", true); //A file with this name will be created. If the file already exist, it will be edited.
            PrintWriter printWriter = new PrintWriter(fileWriter); //This will enable me to write on the file

            //These are what I want to be written in the file: fw_pw1.txt
            printWriter.println("I am writing on a text file");
            printWriter.println("Using Java :) :) :)");
            printWriter.println("with the Classes: FileWriter and PrintWriter.");
            printWriter.println("It's pretty cool! :))))");

            //This is where the data will be actually written in the file
            printWriter.flush();

            //This will be displayed on my console when the job is done.
            System.out.println("File created successfully.");

            //This is where I close the file.
            printWriter.close();
        }

        public static void writeInFileClassRoomSolution() throws IOException {
            File file = new File("fw_pw2.txt");
            java.io.FileWriter fileWriter1 = new FileWriter(file, true); //with append, it will add new printWriter.println commands to the file but will not edit it.
            PrintWriter printWriter1 = new PrintWriter(fileWriter1);

            printWriter1.println("row 1");
            printWriter1.println("row 2");
            printWriter1.println("row 3");

            printWriter1.flush();
            printWriter1.close();

            System.out.println("File created successfully!");
        }

    }
