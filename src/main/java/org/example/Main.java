package org.example;
import Advent.Node;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        day1();
    }

        public static String[] readFile(String dir){


        try {
                File myObj = new File(dir);
                Scanner myReader = new Scanner(myObj);
                int i = 0;
                String[] result = new String[1001];
                while (myReader.hasNextLine()) {
                    result[i] = myReader.nextLine();

                    i = i+ 1;
                }

                myReader.close();
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
            return result;
        }
        public static void day1(){
            int[] leftside = new int[1001];
            int[] rightside = new int[1001];
            Node left = new Node(0);
            Node right = new Node(0);
            String[] data = readFile("/home/sascha/Documents/Advent/input");
            int i = 0;
            for (String line : data) {

                leftside[i] = Integer.parseInt(line.split(" {3}")[0]);
                rightside[i] = Integer.parseInt(line.split(" {3}")[1]);
                left.append(Integer.parseInt(line.split(" {3}")[0]));
                right.append(Integer.parseInt(line.split(" {3}")[1]));
                i += 1;
            }
            int result = 0;
            Node lPointer = left;
            Node rPointer = right;
            while (lPointer.next() != null) {
                result += Math.abs(lPointer.next().getNUMBER() - rPointer.next().getNUMBER());
                lPointer = lPointer.next();
                rPointer = rPointer.next();
            }
            System.out.println("Aufgab1: " + result);

            // AUfgabe 2:
            /**
             lPointer = left;
             rPointer = right;
             result = 0;
             for (int i = 0; i < left.getLength(); i++){
             rPointer = right;
             for (int j = 0; j < right.getLength(); j++) {
             if (lPointer.next().getNUMBER() == rPointer.next().getNUMBER()) {
             result += lPointer.next().getNUMBER();
             }

             if(rPointer.next() != null) {
             rPointer = rPointer.next();
             }else{
             continue;
             }
             }
             if(lPointer.next() != null) {
             lPointer = lPointer.next();
             }else{
             break;
             }
             }
             */
            int result2 = 0;
            for(int i=0; i<leftside.length; i++) {
                for(int j=0; j<rightside.length; j++) {
                    if(leftside[i] == rightside[j]) {
                        result2 += leftside[i];
                    }
                }
            }

            System.out.println("Aufgab2: " + result2);

        }
    }