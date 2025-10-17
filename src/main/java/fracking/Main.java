package fracking;

import java.nio.file.*;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("src/fracking.txt"));
        int index = 0;

        int amount = Integer.parseInt(lines.get(index++));



        for (int iterations = 0; iterations < amount; iterations++){

            int height = Integer.parseInt(lines.get(index++));
            int width = Integer.parseInt(lines.get(index++));
            char[][] grond = new char[height][width];
            for (int i = 0; i < height; i++) {
                String line = lines.get(index++);
                grond[i] = line.toCharArray();
                // Optional: print the row
            }

//            System.out.println(calculate(grond));

            System.out.println(calculate(grond));
        }


    }

    public static int calculate(char[][] input){
        char[][] newGround = input;

        int amountOfDays = 0;

        if (checkInstorting(newGround)){
            return amountOfDays;
        }

        while(true){
            char[][] nextGround = deepCopy(newGround);
            for (int i = 0; i < newGround.length; i++) {
                for (int j = 0; j < newGround[i].length; j++) {
                    if (newGround[i][j] == '.') {
                        if (i - 1 >= 0) nextGround[i - 1][j] = '.';
                        if (i + 1 < newGround.length) nextGround[i + 1][j] = '.';
                        if (j - 1 >= 0) nextGround[i][j - 1] = '.';
                        if (j + 1 < newGround[i].length) nextGround[i][j + 1] = '.';
                    }
                }
            }
            newGround = nextGround;

            amountOfDays++;
//            print(newGround);
            if (checkInstorting(newGround)){
                return amountOfDays;
            }
        }
    }



    public static boolean checkInstorting(char[][] input){
        for (int i = 0; i < input.length; i++) {
            boolean allDots = true;
            for (int j = 0; j < input[i].length; j++) {
                if (input[i][j] != '.') {
                    allDots = false;
                    break;
                }
            }
            if (allDots) return true;
        }
        return false;
    }

    public static void print(char[][] input) {
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[i].length; j++) {
                System.out.print(input[i][j]);
            }
            System.out.println();
        }
    }

    public static char[][] deepCopy(char[][] original) {
        char[][] copy = new char[original.length][];
        for (int i = 0; i < original.length; i++) {
            copy[i] = original[i].clone();
        }
        return copy;
    }
}