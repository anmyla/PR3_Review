package a_FileClass;

import java.io.File;
import java.io.IOException;

public class FileClass_MethodsGetFile {
    public static void main(String[] args) {
        // Example using a file ABSOLUTE PATH
        // File file = new File("C:\\Users\\s53026\\IdeaProjects\\PR3\\test.txt");

        //Example using a file with relative path
        File file = new File("sample.txt"); //file in the same Java Project FOlder
        printFileInfo(file);

        //Create a new File
        createNewFile("createFile.txt");

        //List all directories
        String directoryPath = "/Users/myla/Documents/Java Projects"; //mac uses slash instead of backslash
        listFilesAndDirectories(directoryPath);
    }

    public static void printFileInfo(File file) {
        System.out.println("Does this file exist? " + file.exists());
        System.out.println("Name of the File: " + file.getName());
        System.out.println("Parent Directory of the File: " + file.getParent());
        System.out.println("Path to this File: " + file.getAbsolutePath());
        System.out.println("Is this a directory? " + file.isDirectory());
        System.out.println("Is this a file? " + file.isFile());
        System.out.println("Is this file readable? " + file.canRead());
        System.out.println("Is this File writeable? " + file.canWrite());
        System.out.println("Is this file hidden: " + file.isHidden());
        System.out.println("File Size: " + file.length() + " bytes");
        System.out.println("File Size: " + file.length() / 1024.0 + " kilobytes");

    }

    public static void createNewFile(String filePath) {
        File file = new File("k.txt");

        try {
            if (file.createNewFile()) {
                System.out.println("File created successfully.");
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while creating the file: " + e.getMessage());
        }
    }

    public static void listFilesAndDirectories(String directoryPath) {
        File directory = new File(directoryPath);

        if (!directory.isDirectory()) {
            System.out.println("Invalid directory path.");
            return;
        }

        if (!directory.exists()) {
            System.out.println("Error: There's not such directory!");
            return;
        }

        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    System.out.println("Dir:" + file.getAbsolutePath());
                } else {
                    System.out.println("File:" + file.getAbsolutePath());
                }
            }
        }
    }
}

