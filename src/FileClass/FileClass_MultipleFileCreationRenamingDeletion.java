package FileClass;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

public class FileClass_MultipleFileCreationRenamingDeletion {
    public static void main(String[] args) {
        /*
    Goal: Create 10 Files + Rename all files (only files) of the given directory (not for subdirectories)

    1. Create a method, which creates 10 files, in a given directory (= Method Parameter) and with a random file name/number (Tip: concatenate for final filepath)
    2. Create a method, which renames all files (only files and not directories!) within a given folder (= Method Parameter)
        2.1 for example: test.txt to 1_test.txt
            2.1.1 for the new file name - concatenate a string with .getParent(), separator + pre_id +  getName()
            2.1.2 use renameTo() method
            2.1.3 Check if the rename was a success (via if) and print the according message to the console
    3. Write a method, which deletes all files within this directory. (Comment out this or other methods to test it..)

    Tip: Random Number:
        ThreadLocalRandom.current().nextInt()

         */

        File dir = new File("/Users/myla/Desktop/PR3 Review/sampleFolder");

        createFiles(dir);
        renameFiles(dir);
        deleteFiles(dir);
    }

    private static void deleteFiles(File dir) {
        for (File currentFile : dir.listFiles()) {
            if (currentFile.isFile()) {
                if (currentFile.delete()) {
                    System.out.println("Erfolg: File " + currentFile.getAbsolutePath() + " was deleted");
                }
            }
        }
    }
    private static void renameFiles(File dir) {
        for (File currentFile : dir.listFiles()) {
            if (currentFile.isFile()) {
                File destFile = new File(dir.getAbsolutePath() +
                        File.separator + "1_" + currentFile.getName());
                if (currentFile.renameTo(destFile)) {
                    System.out.println("Erfolg: File " + currentFile.getAbsolutePath() +
                            " was renamed to " + destFile.getAbsolutePath());
                }
            }
        }
    }


    private static void createFiles(File dir) {

        for (int i = 0; i < 10; i++) {
            String filename = ThreadLocalRandom.current().nextInt() + ".mp3";
            File fileToCreate = new File(dir.getAbsolutePath() + File.separator + filename);
            //System.out.println("File " + i + ": " + fileToCreate.getAbsolutePath());

            try {
                fileToCreate.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if (fileToCreate.exists())
                System.out.println("File " + fileToCreate.getAbsolutePath() + " CREATED");
            else
                System.out.println("ERROR: File " + fileToCreate.getAbsolutePath() +
                        " could NOT beCREATED");
        }
    }


}