package waterton;


import java.nio.file.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("src/waterton.txt"));
        int index = 0;

        int amount = Integer.parseInt(lines.get(index++));

        for (int i = 0; i < amount; i++){
            // Convert ArrayList to int[]
            ArrayList<String> tons = new ArrayList<>();
            String[] parts = lines.get(index++).split(" ");
            for (int j = 0; j < parts.length; j++) {
                tons.add(parts[j]);
            }
            int[] tonsArray = tons.stream().mapToInt(Integer::parseInt).toArray();
            int[] result = waterdoorlopen(tonsArray);
            if (result[0] == result[1]){
                System.out.println("gelijk");
            } else {
                System.out.println(result[0] + " " + result[1]);
            }

        }



    }

    public static int hoogsteBuis(int[] input){
        int[] water = { input[0], input[1] };
        int[] height = { input[2], input[3] };


        if (height[0] > height[1]){
            return 0;
        } else if (height[0] == height[1]){
            if (water[0] > water[1]){
                return 0;
            }
        }  return 1;

    }

    public static int hoogstewater(int[] input){
        int[] water = { input[0], input[1] };


        if (water[0] > water[1]){
            return 0;
        }   return 1;
    }

    public static int reverse(int input){
        if(input == 1){
            return 0;
        } else return 1;
    }

    public static int[] waterdoorlopen(int[] input){
        int hoogste = hoogsteBuis(input);
        int hoogstewater = hoogstewater(input);

        int lowest = reverse(hoogste);
        int lowestwater = reverse(hoogstewater);

        int[] water = { input[0], input[1] };
        int[] height = { input[2], input[3] };

        while(water[hoogstewater] > height[hoogste]){
            if (water[lowestwater] < water[hoogstewater]){
                water[lowestwater]++;
                water[hoogstewater]--;
            } else return water;
        }

        return water;
    }

}

