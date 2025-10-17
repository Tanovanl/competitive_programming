package aandelen;


import java.nio.file.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("src/aandelen.txt"));
        int index = 0;

        int amount = Integer.parseInt(lines.get(index++));

        // Inside main method, before parsing lengthArray and events
        for (int i = 0; i < amount; i++) {
            int startAmount = Integer.parseInt(lines.get(index++));
            String lengthLine = lines.get(index);
            if (lengthLine == null || lengthLine.trim().isEmpty()) {
                System.out.println(startAmount); // Print start amount if line is empty
                index++; // Skip to next line if empty
                continue;
            }
            int lengthArray = Integer.parseInt(lines.get(index++));
            String eventLine = lines.get(index);
            if (lengthArray == 0 || eventLine == null || eventLine.trim().isEmpty()) {
                System.out.println(startAmount); // Print start amount if line is empty

                index++; // Skip to next line if empty
                continue;
            }
            int[] events = Arrays.stream(eventLine.split(" ")).mapToInt(Integer::parseInt).toArray();
            index++;
            System.out.print(calculate(events, startAmount));
            System.out.println();
        }


    }

    public static int calculate(int[] input, int startAmount) {
//        //System.out.println(Arrays.toString(input));
//        //System.out.println(startAmount);

        if (!isWin(input, 0)) return startAmount;

        int[][] transactions = transaction(input, startAmount);

        for (int i = 0; i < transactions.length; i++){
            if (transactions[i][0] == 0 && transactions[i][1] == 0) break;
            //System.out.println("Buy at: " + transactions[i][0] + " Sell at: " + transactions[i][1]);
            //System.out.println("Amount before transaction: " + startAmount);
            startAmount = completeTransaction(transactions[i][0], transactions[i][1], startAmount);
            //System.out.println("Current amount: " + startAmount);
        }

        return startAmount;


    }

    public static boolean isWin(int[] input, int startpoint){
        for (int i = startpoint; i < input.length - 1; i++){
            if(input[i] < input[i + 1]) return true;
        }
        return false;
    }

    public static int findBuyPoint(int[] input, int amount, int startpoint){

        for (int i = startpoint; i < input.length; i++){
            int nextIndex = (i + 1) % input.length;
            if(input[i] < input[nextIndex] && input[i] <= amount){
                return i;
            }
        }
        return -1;
    }

    public static int findSellingPoint(int[] input, int startpoint){
        int highestIndex = startpoint;
        int highest = input[startpoint];
        for (int i = startpoint + 1; i < input.length - 1; i ++){
            if(input[i] > highest){
                highestIndex = i;
                highest = input[i];
            }
        }
        return highestIndex;
    }

    public static int completeTransaction(int buy, int sell, int money){
        int stocks = money / buy;
        money = money % buy;
        money += stocks * sell;
        return money;
    }

    public static int[][] transaction(int[] input, int amount){
        int[][] transactions = new int[input.length / 2][2];
        int startpoint = 0;
        int amountTransactions = 0;
        while (true){
            int indexBuy = findBuyPoint(input, amount, startpoint);
            if (indexBuy == -1) break;
            int indexSell = findSellingPoint(input, indexBuy + 1);

            startpoint = indexSell + 1;
            int[] transaction = { input[indexBuy], input[indexSell] };
            transactions[amountTransactions] = transaction;
            amountTransactions++;
            if (!isWin(input, startpoint)) {
                break;
            }
        }

        return transactions;
    }


}

