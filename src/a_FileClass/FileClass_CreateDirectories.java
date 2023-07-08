package a_FileClass;

import java.io.File;
/*


Tip: use mkdirs()
Write a method, which creates multiple directories. Example: "C:\\campus02\\test\\demo4" (Campus, Test, Demo4 will be created)
- It should also be checked, if the given directory has been created -> print it to the console:
-> IF Yes: Directory C:\campus02\test\demo4 created?: true
-> IF No: Directory C:\campus02\test\demo4 created?: false

Question: What is the difference between mkdirs() and mkdir() ?
Answer: mkdirs() create parent directory and ensures that all directories in the specified path are created
mkdir() creates a directory only if the parent directory already exists. It does not create any parent directories.
Question: What does mkdirs() return? = boolean value
Question: What does mkdir() return? = boolean value

*/

public class FileClass_CreateDirectories {
        public static void main(String[] args) {
            File f = new File("/Users/myla/Desktop/PR3 Review/sampleFolder/sample1/sample2/sample3");
            if (f.mkdirs()) {
                System.out.println("Directory " + f.getAbsolutePath() + " created?: " + f.exists());
            } else {
                System.out.println("Directory " + f.getAbsolutePath() + " CANT BE created?: " + f.exists());
            }

            // Delete the directory
            if (f.delete()) {
                System.out.println("Directory " + f.getAbsolutePath() + " deleted?: " + !f.exists());
            } else {
                System.out.println("Directory " + f.getAbsolutePath() + " CANT BE deleted?: " + f.exists());
            }
        }

    }