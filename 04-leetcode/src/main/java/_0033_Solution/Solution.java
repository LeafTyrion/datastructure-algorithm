package _0033_Solution;

/**
 * @author YeYaqiao
 * 33. 搜索旋转排序数组
 */
public class Solution {
    public int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int middle = right - (right - left) / 2;
           if(nums[middle]==target)
               return middle;
           if()
        }

        return -1;

    }
}
