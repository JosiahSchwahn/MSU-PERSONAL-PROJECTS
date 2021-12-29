package com.company;

import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        // Create your hash table
        Array_of_key_values HT = new Array_of_key_values(5);

        //try + catch to read in the file
        try{

            File name = new File("testText.txt");

            Scanner scanner = new Scanner(name);

            int key;
            String value;

            // Read the input file and fills my hash table
            while(scanner.hasNext()){

                key = scanner.nextInt();

                value = scanner.nextLine();

                Key_values temp = new Key_values(key, value);

                HT.add(temp);
            }

            //throws users exception if file is not found
        } catch(FileNotFoundException E){

            System.err.println(E);

        }


        //prints out the Hash table with all the newly added values
        System.out.println("Print original HT");
        HT.print();

        //deletes given key values in hash table
        HT.delete(5032);
        HT.delete(1);
        HT.delete(32055);
        HT.delete(35336);
        HT.delete(123); // Trying to delete an element that is not in the table
        HT.delete(7543);
        HT.delete(6439);
        HT.delete(3530);

        //prints tables after deleting key values above
        System.out.println("\nPrint after removing");
        HT.print();

        //finds the value (name) given the key value
        System.out.println("\nFind names");
        System.out.println(HT.get(53536));
        System.out.println(HT.get(22011));
        System.out.println(HT.get(502385));
        System.out.println(HT.get(353945));
        System.out.println(HT.get(36844));

















    }
}
