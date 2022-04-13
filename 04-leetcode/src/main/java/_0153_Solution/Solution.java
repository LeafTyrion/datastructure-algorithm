package _0153_Solution;

/**
 * @author YeYaqiao
 * 153. 寻找旋转排序数组中的最小值
 */
public class Solution {
    public int findMin(int[] nums) {
        int length = nums.length;
        int left = 0;
        int right = length - 1;
        while (left < right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] < nums[right])
                right = middle;
            else
                left = middle + 1;
        }
        return nums[left];
    }
}