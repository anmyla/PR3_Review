package s_Exercises.Ex1_WriteToFile_ReadAndOutputToConsole;

public class Main2 {
    public static void main(String[] args) {

        System.out.println("Program starting up...");
        Product product1 = new Product("mascara1", 56.52,"Cosmetics");
        Product product2 = new Product("lipstick1", 74.22,"Cosmetics");
        Product product3 = new Product("nori sheets1", 3.40,"Food");
        Product product4 = new Product("potato chips1", 2.02,"Food");
        Product product5 = new Product("iphone 14 pro max", 2300,"Electronics");
        Product product6 = new Product("the legend of zelda TOTK", 60,"Games");

        ProductManagerTryCatch productManager = new ProductManagerTryCatch();

        productManager.add(product1);
        productManager.add(product2);
        productManager.add(product3);
        productManager.add(product4);
        productManager.add(product5);
        productManager.add(product6);

        productManager.saveToFile("Product List.txt");

        productManager.readFromFile("Product List.txt");


    }

}
