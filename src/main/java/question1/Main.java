//package question1;
//
//
//import java.nio.file.*;
//import java.io.IOException;
//import java.util.List;
//
//public class Main {
//    public static void main(String[] args) throws IOException {
//       List<String> lines = Files.readAllLines(Paths.get("src/invoer.txt"));
//
//
//        int aantalNetwerken = Integer.parseInt(lines.get(0));
//        int[][][] netwerken = new int[1][210][1000];
//        int currentLine = 1;
//        int value = Integer.parseInt(lines.get(currentLine));
//
//        for (int i = 0; i < aantalNetwerken; i++){
//            int counter = 0;
//            for (int j = value; j < currentLine + value; j++){
//
//                netwerken[1][i][counter] = Integer.parseInt(lines.get(j));
//                counter++;
//            }
//        }
//
//
//        int line = 1;
//
//
//
//
//
//
//        for (int i = 0; i < aantalNetwerken; i++){
//            int shortestWay = 10000000;
//            for (int j = 0; j < aantalPaden; j++){
//                for(int x = 0; x < aantalPaden; x++){
//                    int length = 0;
//                    if (x != j ){
//                        if (array[j][0] <= array[x][0]){
//                            length = array[x][0];
//                        } else {
//                            length = array[j][0] + array[x][0];
//
//                        }
//                        length += array[j][1];
//
//                        if (length < shortestWay){
//                            shortestWay = length;
//                        }
//                    }
//                }
//            }
//            System.out.println(shortestWay);
//        }
//
//    }
//
//}
//
