package FileClass;

import java.io.File;

public class FileClass_PropertiesPrintedOnConsole {
    public static void main(String[] args) {
        File file = new File("/Users/myla/Documents/Java Projects/PR3");
        printDirectoryContent(file);
    }
    public static void printDirectoryContent(File f) {
        if (f.isDirectory()) {
            // Variable initialized
            long filesize = 0;
            // Go through the directory; listFiles() returns an array of Files (Objects)
            for (File file : f.listFiles()) {
                if (file.isFile()) {
                    System.out.println("Filename: " + file.getName() + " Size: " + file.length());
                    filesize = filesize + file.length();
                }
            }
            // print out the complete size of the directory
            System.out.println(filesize);
        } else {
            System.out.println("No Directory");
        }
    }
}
