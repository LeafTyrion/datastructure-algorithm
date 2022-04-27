package _0121_Solution;

/**
 * @author YeYaqiao
 * 121. 买卖股票的最佳时机
 * 7,1,5,3,6,4
 */
public class Solution {
    //记录一个最佳利润和最佳买入点
    public int maxProfit(int[] prices) {
        int buy = prices[0];
        int result = 0;
        for (int price : prices) {
            if (buy > price)
                buy = price;
            result = Math.max(result, price - buy);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.maxProfit(new int[]{7, 1, 5, 3, 6, 4});
    }
}
