package _0053_Solution;

/**
 * @author YeYaqiao
 * 53. 最大子数组和
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        int sum = 0;
        for (int num : nums) {
            sum=Math.max(num+sum,num);
            res=Math.max(sum,res);
        }
        return res;
    }
}
