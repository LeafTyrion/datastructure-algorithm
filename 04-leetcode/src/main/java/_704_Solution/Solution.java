package _704_Solution;

/**
 * @author YeYaqiao
 * 704. 二分查找
 */
public class Solution {
    public int search(int[] nums, int target) {
        int min = 0;
        int max = nums.length - 1;
        int mid;

        while (min <= max) {
//            middle = (min + max) / 2;
            mid = min + (max - min) / 2;//此写法可以防止相加后 int 溢出

            if (nums[mid] == target)
                return mid;
            if (nums[mid] < target)
                min = mid + 1;
            if (nums[mid] > target)
                max = mid - 1;
        }
        return -1;
    }
}
