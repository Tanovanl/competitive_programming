package question2;//package question2;
//
//
//import java.nio.file.*;
//import java.io.IOException;
//import java.util.List;
//
//public class Main {
//    public static void main(String[] args) throws IOException {
//        List<String> lines = Files.readAllLines(Paths.get("src/invoer2.txt"));
//
//        int total = Integer.parseInt(lines.get(0));
//        int infoLine = 1;
//        int[] arrays;
//        for (int i = 1; i < total; i++)
//        {
//            arrays[iString[] dims = lines.get(i).split(" ");
//
//        }
//
//        int[][] cases;
//        for (int i = 0; i < total; i++){
//            String[] dims = lines.get(infoLine).split(" ");
//            int height = Integer.parseInt(dims[1]);
//            //infoLine = height + 1;
//            int length = Integer.parseInt(dims[0]);
//            int counter = 0;
//            for(int height1 = infoLine + 1; height1 < infoLine + 1 + height; height1++ ){
//                String[] line = lines.get(infoLine).split(" ");
//                for (int length1 = 0; length1 < length; length1++){
//                    cases[counter][]
//                }
//            }
//
//        }
//
//
//    }
//
//}
//


import java.nio.file.*;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Read all lines from file
        List<String> lines = Files.readAllLines(Paths.get("src/invoer2.txt"));
        int index = 0;

        int t = Integer.parseInt(lines.get(index++));

        for (int test = 0; test < t; test++) {
            String[] parts = lines.get(index++).split(" ");
            int k = Integer.parseInt(parts[0]);
            int r = Integer.parseInt(parts[1]);

            int[] colCounts = new int[k];

            for (int i = 0; i < r; i++) {
                String line = lines.get(index++);
                for (int j = 0; j < k; j++) {
                    if (line.charAt(j) == '*') {
                        colCounts[j]++;
                    }
                }
            }
            System.out.println(calculate(colCounts));
            // Debug print
//            System.out.println("Testcase " + (test + 1) + ": " + Arrays.toString(colCounts));
        }

        int[] testArray = {1, 4, 3, 2, 5, 3, 6, 5};



        System.out.println(Main.calculate(testArray));
    }

    public static int calculate(int[] input){
        int biggest = 0;
        int padding = 0;
        for (int i = 0; i < input.length; i++){

            if (input[i] > biggest){
                biggest = input[i];
            } else {
                padding += biggest - input[i];
            }
        }

        return padding;
    }
}

