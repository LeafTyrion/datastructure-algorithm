package _0042_Solution;

/**
 * @author YeYaqiao
 * 42. 接雨水
 */
public class Solution {

    //双指针
    public int trap(int[] height) {
        //设置左右指针
        int l = 0, r = height.length - 1;
        //自己左右两边的最大值
        int lMax = 0, rMax = 0;
        int res = 0;
        while (l < r) {
            int left = height[l];
            int right = height[r];
            lMax = Math.max(lMax, left);
            rMax = Math.max(rMax, right);
            if (lMax < rMax) {
                //当左边的最大值小于右边的最大值时，则l位置所能存储的雨水为 lMax - left
                res += lMax - left;
                l++;
            } else {
                //当左边的最大值大于等于右边的最大值时，则l位置所能存储的雨水为 rMax - right
                res += rMax - right;
                r--;
            }
        }
        return res;
    }
}
