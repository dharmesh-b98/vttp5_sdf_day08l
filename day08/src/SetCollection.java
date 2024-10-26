package src;

import java.io.*;
import java.util.*;

public class SetCollection {
    public static void main(String[] args) {
        Console console = System.console();

        String keyboardInput = "";
        while (true){
            keyboardInput = console.readLine("Input 4 letters or numbers separated by spaces");
            keyboardInput = keyboardInput.toUpperCase().trim();
            if (keyboardInput.length() ==7){
                break;
            }
            else{
                System.out.println("Wrong Input");
            }
        }

        String[] inputList = keyboardInput.split(" ");
        List<String> inputList2 = new ArrayList<>();
        for (String item: inputList){
            inputList2.add(item);
        }
        

        for (String input : inputList2){
            List<String> subList1 = new ArrayList<>(inputList2);  // shallow copy method to duplicate a list
            subList1.remove(input);
            for (String subinput1 : subList1){
                List<String> subList2 = new ArrayList<>(subList1);
                subList2.remove(subinput1);
                for (String subinput2 : subList2){
                    List<String> subList3 = new ArrayList<>(subList2);
                    subList3.remove(subinput2);
                    for (String subinput3 : subList3){
                        StringBuilder sb = new StringBuilder();
                        sb.append(input);
                        sb.append(subinput1);
                        sb.append(subinput2);
                        sb.append(subinput3);
                        System.out.println(sb);
                    }
                }
            }
        }


        // Given 4 digits or 4 alphabets
        // Find the number of permutations
        // put the permutation into Set Collection
        String word = "ABCD";
        String[] chr = new String[word.length()];
        for (int i = 0; i < word.length(); i++) {
            chr[i] = String.valueOf(word.charAt(i));
        }

        List<String> combinations = new ArrayList<>();

        int loop = 0;
        while (loop < word.length()) {
            int count = 0;
            for (int i = 0; i < word.length(); i++) {
                String temp = "";
                temp = chr[i];

                for (int j = i + 1; j < word.length(); j++) {
                    temp = temp + chr[j];
                }
                if (temp.length() == word.length())
                    combinations.add((temp));

            }

            String tmp = "";
            tmp = chr[count]; 
            for(int cnt = 0; cnt < word.length(); cnt++) {
                if (cnt < (word.length() -1)){
                    chr[cnt] = chr[cnt + 1];
                }
                else {
                    chr[cnt] = tmp;
                } 
            } 

            loop++;
        }

        for (String a : combinations) {
            System.out.println(a.toString());
        }


        


    }
}
