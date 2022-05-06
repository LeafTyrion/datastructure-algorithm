package _0312_Solution;

/**
 * @author YeYaqiao
 * 312. 戳气球
 */
public class Solution {
    //动态规划
    //dp[i][j]=dp[i][k]+val[i]*val[k]*val[j]+dp[k][j]
    //两边设置两个假点
    public int maxCoins(int[] nums) {
        int length = nums.length;
        int[][] dp = new int[length + 2][length + 2];
        int[] val = new int[length + 2];
        val[0] = val[length + 1] = 1;
        System.arraycopy(nums, 0, val, 1, length);
        for (int i = length - 1; i >= 0; i--) {
            for (int j = i + 2; j <= length + 1; j++) {
                for (int k = i + 1; k < j; k++) {
                    int sum = val[i] * val[k] * val[j];
                    sum += dp[i][k] + dp[k][j];
                    dp[i][j] = Math.max(dp[i][j], sum);
                }
            }
        }
        return dp[0][length + 1];
    }

    //回溯法递归，超时
//    public int maxCoins(int[] nums) {
//        LinkedList<Integer> arr = new LinkedList<>();
//        for (int i = 0; i < nums.length; i++) {
//            arr.add(i, nums[i]);
//        }
//        return recur(arr);
//    }
//
//    public int recur(LinkedList<Integer> arr) {
//        if (arr.size() == 0)
//            return 0;
//        int length = arr.size();
//        int res = 0;
//        for (int i = 0; i < length; i++) {
//            int left = i - 1 < 0 ? 1 : arr.get(i - 1);
//            int right = i + 1 >= length ? 1 : arr.get(i + 1);
//            int total = arr.get(i) * left * right;
//            int temp = arr.remove(i);
//            total += recur(arr);
//            res = Math.max(total, res);
//            arr.add(i, temp);
//        }
//        return res;
//    }
}
