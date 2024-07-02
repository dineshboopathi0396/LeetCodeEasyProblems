package com.dsa.Arrays;

public class BuySellStock {
    public static void main(String[] args) {
        int prices[] = {1, 2};
        System.out.println(maxProfit1(prices));
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit1(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if ((prices[j] - prices[i]) > max)
                    max = prices[j] - prices[i];
            }
        }
        return max;
    }

    public static int maxProfit(int[] prices) {
        int profit = 0;
        int buy = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (buy > prices[i]) {
                buy = prices[i];
            } else if (profit < (prices[i] - buy)) {
                profit = prices[i] - buy;
            }
        }
        return profit;
    }
}
