package s_Exercises.Ex1_WriteToFile_ReadAndOutputToConsole;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductManagerTryCatch {

    private List<Product> productList = new ArrayList<>();

    public void add(Product p) {
        productList.add(p);
    }

    public void saveToFile(String filePath) {
        File file = new File(filePath);
        FileWriter fileWriter = null;
        BufferedWriter writer = null;

        try {
            fileWriter = new FileWriter(file);
            writer = new BufferedWriter(fileWriter);

            for (Product p : productList) {
                System.out.println("Product Manager: SavedToTextFile: " + p.toString());
                writer.write(p.toString());
                writer.newLine();
            }
            System.out.println("flushing");
            writer.flush();
            System.out.println("closing " + filePath + "....");
        } catch (IOException e) {
            System.out.println("Ops, an error has occurred....");
            e.printStackTrace();
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
                if (fileWriter != null) {
                    fileWriter.close();
                }
            } catch (IOException e) {
                System.out.println("Ops, an error has occurred....");
                e.printStackTrace();
            }
        }
    }

    public void readFromFile(String filePath) {
        File file = new File(filePath);
        FileReader fileReader = null;
        BufferedReader reader = null;

        try {
            fileReader = new FileReader(file);
            reader = new BufferedReader(fileReader);

            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                line = reader.readLine();
            }
        } catch (IOException e) {
            System.out.println("Ops, an error has occurred....");
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
                if (fileReader != null) {
                    fileReader.close();
                }
            } catch (IOException e) {
                System.out.println("Ops, an error has occurred....");
                e.printStackTrace();
            }
        }
    }
}