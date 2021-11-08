package _0035_Solution;

/**
 * @author YeYaqiao
 * 35. 搜索插入位置
 */
public class Solution {
    public int searchInsert(int[] nums, int target) {
        int min = 0;
        int max = nums.length - 1;
        //若target大于数组最大值，则循环结束后 min 会溢出一位 nums.length
        //若target小于数组最小值，则循环结束后 max 会溢出一位 0-1
        //若target等于当前值，则不断缩小 max 直到 max 小于 min
        while (min <= max) {
            int mid = min + (max - min) / 2;
            if (nums[mid] < target)
                min = mid + 1;
            else
                max = mid - 1;
        }
        return min;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.searchInsert(new int[]{1, 3, 5, 7}, 5);
    }
}
