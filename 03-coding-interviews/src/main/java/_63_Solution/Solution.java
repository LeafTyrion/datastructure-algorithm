package _63_Solution;

/**
 * @author YeYaqiao
 * 剑指 Offer 63. 股票的最大利润
 */
public class Solution {

    //动态规划
    public int maxProfit(int[] prices) {
        int cost = Integer.MAX_VALUE, profit = 0;
        for (int price : prices) {
            cost = Math.min(cost, price);
            profit = Math.max(profit, price - cost);
        }
        return profit;
    }

    //暴力法
//    public int maxProfit(int[] prices) {
//        int max = 0;
//        for (int i = 0; i < prices.length; i++) {
//            for (int j = i; j < prices.length; j++) {
//                if (prices[j] - prices[i] > max)
//                    max = prices[j] - prices[i];
//            }
//        }
//        return max;
//    }
}
