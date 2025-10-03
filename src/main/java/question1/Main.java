package question1;


import java.nio.file.*;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
       List<String> lines = Files.readAllLines(Paths.get("src/invoer.txt"));


        int aantalNetwerken = Integer.parseInt(lines.get(0));
        int aantalPaden = Integer.parseInt(lines.get(1));
        int line = 1;

        int[][] array = new int[10000][2];

        for (int j = 0; j < aantalNetwerken; j++){
            for (int i = line + 2; i < Integer.parseInt(lines.get(line)) + 1; i++) {
                String[] parts = lines.get(i).split(" ");
                array[i][0] = Integer.parseInt(parts[0]);
                array[i][1] = Integer.parseInt(parts[1]);
                System.out.println(array[i][0]);
            }
            line += Integer.parseInt(lines.get(line)) + 1;
        }



        for (int i = 0; i < aantalNetwerken; i++){
            int shortestWay = 10000000;
            for (int j = 0; j < aantalPaden; j++){
                for(int x = 0; x < aantalPaden; x++){
                    int length = 0;
                    if (x != j ){
                        if (array[j][0] <= array[x][0]){
                            length = array[x][0];
                        } else {
                            length = array[j][0] + array[x][0];

                        }
                        length += array[j][1];

                        if (length < shortestWay){
                            shortestWay = length;
                        }
                    }
                }
            }
            System.out.println(shortestWay);
        }

    }
}

