package _0279_Solution;

/**
 * @author YeYaqiao
 * 279. 完全平方数
 */
public class Solution {
    //dp[i]=Math.min(dp[i],dp[i-j*j]+1)
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                min = Math.min(min, dp[i - j * j]);
            }
            dp[i] = min + 1;
        }
        return dp[n];
    }
}
