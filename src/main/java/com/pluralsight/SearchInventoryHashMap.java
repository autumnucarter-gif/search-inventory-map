package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;

public class SearchInventoryHashMap {

    public static HashMap<Integer, Product> inventory =
            new HashMap<Integer, Product>();

    public static void main(String[] args) {
        // this method loads product objects into inventory
        loadInventory();
        Scanner scanner = new Scanner(System.in);
        System.out.print("What item # are you interested in? ");
        int id = scanner.nextInt();
        Product matchedProduct = inventory.get(id);
        if (matchedProduct == null) {
            System.out.println("We don't carry that product");
        } else {
            System.out.printf("We carry %s and the price is $%.2f",
                    matchedProduct.getName(), matchedProduct.getPrice());
        }
    }

    private static void loadInventory(){
        String filename = "inventory.csv";
        // Your code should be here
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));
            String line;


            while((line = bufferedReader.readLine()) != null) {
                String[] tokens = line.split("\\|");

                int iD = Integer.parseInt(tokens[0]);
                String name = tokens[1];
                double price = Double.parseDouble(tokens[2]);

               inventory.put(iD, new Product(iD, name, price));
            }

            bufferedReader.close();



        } catch (Exception e) {
            throw new RuntimeException(e);
        }




    }

}

