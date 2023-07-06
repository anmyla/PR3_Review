package FileClass;

import java.io.File;

public class FileClass_DirectoryList_Recursive {
    public static void main(String[] args) {

        File fileList = new File("/Users/myla/Documents/Java Projects");
        String directoryPath2 = "/Users/myla/Documents/Java Projects"; //mac path
        listFilesAndDirectoriesWithSubFolders(directoryPath2);
        listOfFilesAndDirsRecursive(fileList);


    }
    public static void listFilesAndDirectoriesWithSubFolders(String path) {
        File root = new File(path);
        File[] list = root.listFiles();

        if (list == null) return;

        for (File f : list) {
            if (f.isDirectory()) {
                // rekursiver Aufruf
                System.out.println("Directory: " + f.getAbsolutePath());
                listFilesAndDirectoriesWithSubFolders(f.getAbsolutePath());
            } else {
                System.out.println("File: " + f.getAbsolutePath());
            }
        }
    }

    private static void listOfFilesAndDirsRecursive(File directory) {
        File[] filesList = directory.listFiles();
        int counter = 0;
        if (filesList != null) {
            for (File item : filesList) {
                if (item.isDirectory()) {
                    System.out.println("Index: [" +counter+   "] DIR: " + item.getAbsolutePath());
                    listOfFilesAndDirsRecursive(item);
                } else {
                    System.out.println("Index: [" +counter+   "] FILE: " + item.getAbsolutePath());
                }
                counter++;
            }
        }
    }
}
