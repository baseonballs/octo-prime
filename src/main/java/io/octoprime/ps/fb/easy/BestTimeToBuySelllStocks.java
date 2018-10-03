package io.octoprime.ps.fb.easy;

public class BestTimeToBuySelllStocks {


    /**
     * The idea is to check : under current price, what is the minimal price I have seen before,
     * then get the profit, then record the max.
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {

        int min = Integer.MAX_VALUE;
        int max = 0;

        for (int price : prices) {
            if (price < min) {
                min = price;
            } else
                max = Math.max(max, price - min);
        }

        return max;
    }


    public int maxProfit2(int[] prices) {
        int max = 0;
        int profit = 0;

        for (int i = prices.length - 1; i >= 0; i--) {
            if (i == prices.length - 1)
                max = 0;
            else {
                if (max < prices[i + 1])
                    max = prices[i + 1];
            }
            int temp = max - prices[i];
            if (temp > profit)
                profit = temp;
        }

        if (profit < 0) profit = 0;
        return profit;
    }

}
