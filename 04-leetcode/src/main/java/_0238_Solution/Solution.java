package _0238_Solution;

/**
 * @author YeYaqiao
 * 238. 除自身以外数组的乘积
 */
public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];

        int left = 1, right = 1;

        for (int i = 0; i < length; i++) {
            if (i > 0)
                left *= nums[i - 1];
            result[i] = left;
        }

        for (int i=length-1;i>=0;i--) {
            if (i < length - 1)
                right *= nums[i + 1];
            result[i] *= right;
        }
        return result;
    }
}
