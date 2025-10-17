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
        for (int i = 0; i < amount; i++) {
            long startAmount = Long.parseLong(lines.get(index++));
            String lengthLine = lines.get(index);
            if (lengthLine == null || lengthLine.trim().isEmpty()) {
                System.out.println(startAmount);
                index++;
                continue;
            }
            int lengthArray = Integer.parseInt(lines.get(index++));
            String eventLine = lines.get(index);
            if (lengthArray == 0 || eventLine == null || eventLine.trim().isEmpty()) {
                System.out.println(startAmount);
                index++;
                continue;
            }
            long[] events = Arrays.stream(eventLine.split(" ")).mapToLong(Long::parseLong).toArray();
            index++;
            System.out.print(calculate(events, startAmount));
            System.out.println();
        }
    }

    public static long calculate(long[] input, long startAmount) {
        if (!isWin(input, 0)) return startAmount;
        long[][] transactions = transaction(input, startAmount);
        for (int i = 0; i < transactions.length; i++) {
            if (transactions[i][0] == 0 && transactions[i][1] == 0) break;
            startAmount = completeTransaction(transactions[i][0], transactions[i][1], startAmount);
        }
        return startAmount;
    }

    public static boolean isWin(long[] input, int startpoint) {
        for (int i = startpoint; i < input.length - 1; i++) {
            if (input[i] < input[i + 1]) return true;
        }
        return false;
    }

    public static int findBuyPoint(long[] input, long amount, int startpoint) {
        for (int i = startpoint; i < input.length - 1; i++) {
            int nextIndex = i + 1;
            if (input[i] < input[nextIndex] && input[i] <= amount) {
                return i;
            }
        }
        return -1;
    }

    public static int findSellingPoint(long[] input, int startpoint) {
        int highestIndex = startpoint;
        long highest = input[startpoint];
        for (int i = startpoint + 1; i < input.length - 1; i++) {
            if (input[i] > highest) {
                highestIndex = i;
                highest = input[i];
            } else return highestIndex;
        }
        return highestIndex;
    }

    public static long completeTransaction(long buy, long sell, long money) {
        long stocks = money / buy;
        money = money % buy;
        money += stocks * sell;
        return money;
    }

    public static long[][] transaction(long[] input, long amount) {
        long[][] transactions = new long[input.length / 2][2];
        int startpoint = 0;
        int amountTransactions = 0;
        while (true) {
            int indexBuy = findBuyPoint(input, amount, startpoint);
            if (indexBuy == -1) break;
            int indexSell = findSellingPoint(input, indexBuy + 1);

            startpoint = indexSell + 1;
            long[] transaction = { input[indexBuy], input[indexSell] };
            transactions[amountTransactions] = transaction;
            amountTransactions++;
            if (!isWin(input, startpoint)) {
                break;
            }
        }
        return transactions;
    }
}