package src;

import java.util.*;
import java.util.stream.Collectors;
import java.io.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Map.Entry;

public class App {
    public static void main(String[] args) throws IOException {
        String outputFilePath = args[0];
        File outputFile = new File(outputFilePath);
        if(!(outputFile.exists())){
            outputFile.createNewFile();   ////create new file if file does not exist
        }

        /* if (args.length > 0) {
            String[] arguments = args[0].split("/");

            File newDir = new File(arguments[0]);

            if (!newDir.exists()) {
                newDir.mkdir();
            }

            File newPathFile = new File(args[0]);

            if (!newPathFile.exists()) {
                newPathFile.createNewFile();
            }
        } */


        //example of creating custom date
        LocalDate ldCreated = LocalDate.of(2024, 10, 22);
        Date createDt = Date.from(ldCreated.atStartOfDay(ZoneId.systemDefault()).toInstant());
        //System.out.println(createDt);
        


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


        //Using comparator to perform sorting as the function does not know which attribute to compare
        //single column comparison
        Comparator<Product> comparator = Comparator.comparing(p -> p.getProdName());
        productList.sort(comparator);
        productList.forEach(System.out::println);
        System.out.println("------------------------------- \n");

        productList.sort(comparator.reversed()); //descending order
        productList.forEach(System.out::println);
        System.out.println("------------------------------- \n");

        //sort and array of string without using comparator
        String[] nameArr = {"Bernard", "Zachary", "Alpha", "Theophilus", "Sammy", "Christopher"};
        Arrays.sort(nameArr);
        for (String character : nameArr){
            System.out.println(character);
        }
        System.out.println("------------------------------- \n");

        List<String> integerarray = new ArrayList<>();
        integerarray.add("A");
        integerarray.add("D");
        integerarray.add("C");
        integerarray.add("X");
        integerarray.add("B");

        Comparator<String> comp = Comparator.comparing(x -> x.toString());
        integerarray.sort(comp);
            
        for (String letter : integerarray){
            System.out.println(letter);
        }

        System.out.println("------------------------------- \n");

        
        //using Streams and Lambda 
        //filtering with streams
        System.out.println ("____streams and lambda below ____");
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




        //using iterator to write
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


        //Sorting Map object
        System.out.println("Unsorted Map");
        Map<String, Integer> mapObjectList = new HashMap<>();
        mapObjectList.put("Bernard", 100);
        mapObjectList.put("Robert", 80);
        mapObjectList.put("Carrot", 150);
        mapObjectList.put("Blockhead", 30);
        mapObjectList.put("Crazy", 200);
        mapObjectList.put("Clown", 300);
        mapObjectList.forEach((k, v) -> System.out.println(k + " --> " + v));

        List<Entry<String, Integer>> mapList = new ArrayList<>();
        mapList.sort(Entry.comparingByKey());
        mapList.forEach(System.out::println);

        System.out.println("Sorted Map");
        Map<String, Integer> sortedMapObjectList = new HashMap<>();
        sortedMapObjectList = mapObjectList.entrySet().stream().sorted(Entry.comparingByKey()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        sortedMapObjectList.forEach((k,v) -> System.out.println(k + "<-->" + v));
        

    }
}
