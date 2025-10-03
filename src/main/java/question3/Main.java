package question3;


import java.nio.file.*;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        List<String> lines = Files.readAllLines(Paths.get("src/invoer3.txt"));
        int index = 0;

        int amount = Integer.parseInt(lines.get(index++));
        for (int i = 0; i < amount; i++){
            String[] parts = lines.get(index++).split(" ");
            int iterations = Integer.parseInt(parts[0]);
            int[] input = new int[iterations];
            for (int j = 0; j < iterations; j++) {
                input[j] = Integer.parseInt(parts[j + 1]);
            }
            //System.out.println(Arrays.toString(input));
            int result = calculate(input);
            if (result == -1) {
                System.out.println("ONEINDIG");
            } else {
                System.out.println(result);
            }
        }

        int[] testArray = {3, 6, 9};
        //System.out.println(calculate(testArray));

    }

    public static int calculate(int[] input){
        int ticks = 0;

        if (!isDeelbaar(input)){
            return -1;
        }
        while(!equal(input)){
            int[] first = input.clone();
            for (int i = 0; i < input.length; i++){
                if (i == input.length - 1){
                    if (first[i] > first[0]){
                        input[i] -= 1;
                        input[0] += 1;
                    }
                } else if (first[i] > first[i + 1]){
                    input[i] -= 1;
                    input[i + 1] += 1;
                }
            }
            ticks++;
        }


        return ticks;
    }

    public static boolean equal(int[] input) {
        for (int i = 1; i < input.length; i++) {
            if (input[i] != input[0]) {
                return false;
            }
        }
        return true;
    }

    public static boolean isDeelbaar(int[] input){
        int sum = 0;
        for (int i = 0 ; i < input.length; i++){
            sum += input[i];
        }

        return sum % input.length == 0;
    }
}

