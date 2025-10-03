package question2;


import java.nio.file.*;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("src/invoer2.txt"));

        int total = Integer.parseInt(lines.get(0));
        int infoLine = 1;
        int[][] cases;
        for (int i = 0; i < total; i++){
            String[] dims = lines.get(infoLine).split(" ");
            int height = Integer.parseInt(dims[1]);
            //infoLine = height + 1;
            int length = Integer.parseInt(dims[0]);
            int counter = 0;
            for(int height1 = infoLine + 1; height1 < infoLine + 1 + height; height1++ ){
                String[] line = lines.get(infoLine).split(" ");
                for (int length1 = 0; length1 < length; length1++){
                    cases[counter][]
                }
            }

        }


    }

}

