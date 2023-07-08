package z_Exercises.Ex1_WriteToFile_ReadAndOutputToConsole;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class ProductManagerThrows {
    private List<Product> productList = new ArrayList<>();

    public void add(Product p) {
        productList.add(p);
    }

    public void saveToFile(String filePath) throws IOException {
        File file = new File(filePath);
        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter writer = new BufferedWriter(fileWriter);

        for (Product p : productList) {
            System.out.println("Product Manager: SavedToTextFile: " +
            p.toString() + " ");
            writer.write(p.toString());
            writer.newLine();
        }
        System.out.println("flushing");
        writer.flush();
        System.out.println("closing " + filePath + ".... ");
        writer.close();
    }

    public void readFromFile(String filePath)  throws IOException {
        File file = new File(filePath);
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
