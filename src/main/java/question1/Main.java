package question1;


import java.nio.file.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
       List<String> lines = Files.readAllLines(Paths.get("src/invoer.txt"));
        int index = 0;

        int amount = Integer.parseInt(lines.get(index++));

        for (int i = 0; i < amount; i++){
            int paths = Integer.parseInt(lines.get(index++));
            int[][] allPaths = new int[paths][2];
            for (int j = 0; j < paths; j++){
                String[] parts = lines.get(index++).split(" ");
                allPaths[j][0] = Integer.parseInt(parts[0]);
                allPaths[j][1] = Integer.parseInt(parts[1]);
            }
            System.out.println(calculate(allPaths));
        }

        int[][] voorbeeld = {
                {13, 17},
                {19, 11},
                {16, 14},
                {15, 15}
        };

        // System.out.println(calculate(voorbeeld));

    }

    public static int calculate(int[][] input){
        int shortestWay = 10000;
        for (int j = 0; j < input.length; j++){
            for(int x = 0; x < input.length; x++){
                int length = 0;
                if (x != j ){
                    if (input[j][0] <= input[x][0]){
                        length = input[x][0];
                    } else {
                        length = input[j][0] + input[x][0];

                    }
                    length += input[j][1];

                    if (length < shortestWay){
                        shortestWay = length;
                    }
                }
            }
        }
        return shortestWay;
    }

}

