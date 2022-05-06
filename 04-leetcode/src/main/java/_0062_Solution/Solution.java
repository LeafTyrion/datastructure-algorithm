package _0062_Solution;

/**
 * @author YeYaqiao
 * 62. 不同路径
 */
public class Solution {
    //动态规划
    //当前位置的路径数量 dp[i][j]=dp[i-1][j]+dp[i][j-1]
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //dp[0][0~n]=1;
                //dp[0~n][0]=1;
                if (i == 0 || j == 0)
                    dp[i][j] = 1;
                else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }

            }
        }
        return dp[m - 1][n - 1];
    }


//    public int uniquePaths(int m, int n) {
//        //使用数组缓存每个位置的路径数量
//        int[][] cache = new int[m][n];
//        return dfs(m, n, 0, 0, cache);
//    }
//
//    private int dfs(int m, int n, int i, int j, int[][] cache) {
//        //越界返回0
//        if (i >= m || j >= n)
//            return 0;
//        //迭代到右下角返回1
//        if (i == m - 1 && j == n - 1)
//            return 1;
//        if (cache[i][j] != 0)
//            return cache[i][j];
//        //开启递归并缓存每个位置的路径数量
//        int res = dfs(m, n, i + 1, j, cache) + dfs(m, n, i, j + 1, cache);
//        cache[i][j] = res;
//        return res;
//    }
}
