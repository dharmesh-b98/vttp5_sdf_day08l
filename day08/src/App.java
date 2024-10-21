package src;

import java.util.*;
import java.util.stream.Collectors;
import java.io.*;

public class App {
    public static void main(String[] args) throws IOException {
        String outputFilePath = args[0];
        File outputFile = new File(outputFilePath);
        if(!(outputFile.exists())){
            outputFile.createNewFile();
        }

        List<Product> productList = new ArrayList<>();

        Product mouse = new Product(null, "Mouse", "For click UI on screen", "Computer", new Date(), 99.0f);
        Product keyboard = new Product(null, "Keyboard", "Device that allows alpha numeric inputs", "Computer", new Date(), 235.5f);
        Product monitor = new Product(null, "15.6 inch Monitor", "Extended display panel", "Computer", new Date(), 157.5f);
        Product phone1 = new Product(null, "HuaWei Pura 70 Ultra", "HuaWei phone", "Mobile", new Date(), 900.0f);
        Product phone2 = new Product(null, "HuaWei Mate 50 Pr", "HuaWei phone", "Mobile", new Date(), 1200.0f);
        Product phone3 = new Product(null, "iPhone 16 Pro", "iPhone", "Mobile", new Date(), 2000.0f);
        Product phone4 = new Product(null, "iPhone 14 Pro", "iPhone", "Mobile", new Date(), 1800.0f);

        productList.add(mouse);
        productList.add(keyboard);
        productList.add(monitor);
        productList.add(phone1);
        productList.add(phone2);
        productList.add(phone3);
        productList.add(phone4);


        //Using comparator to perform sorting
        //single column comparison
        Comparator<Product> comparator = Comparator.comparing(p -> p.getProdName());
        productList.sort(comparator);
        productList.forEach(System.out::println);
        System.out.println("------------------------------- \n");

        productList.sort(comparator.reversed()); //descending order
        productList.forEach(System.out::println);
        System.out.println("------------------------------- \n");

        //sort and array of string
        String[] nameArr = {"Bernard", "Zachary", "Alpha", "Theophilus", "Sammy", "Christopher"};
        Arrays.sort(nameArr);
        for (String character : nameArr){
            System.out.println(character);
        }
        System.out.println("------------------------------- \n");

        
        //using Streams and Lambda 
        //filtering with streams
        

        List<Product> filteredProducts = productList.stream()
            .filter(product -> product.getProdCategory().equals("Mobile"))
            .filter(product -> product.getPrice() > 1500.0f)
            .collect(Collectors.toList());
            //.forEach(System.out::println);

        /* productList.stream()
            .filter(product -> product.getProdCategory().equals("Mobile"))
            .filter(product -> product.getPrice() > 1500.0f)
            .map(product -> product.getProdName())
            .forEach(System.out::println); */



        FileWriter fw = new FileWriter(outputFile);
        BufferedWriter bw = new BufferedWriter(fw);

        Iterator<Product> iterator = filteredProducts.iterator();
        while (iterator.hasNext()){
            bw.append(iterator.next().toString());
            bw.newLine();
        }
        bw.flush();
        bw.close();
        fw.close();



        

    }
}
