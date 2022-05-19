package _0034_Solution;

/**
 * @author YeYaqiao
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 */
public class Solution {

    //二分法寻找边界
    public int[] searchRange(int[] nums, int target) {
        int l = binarySearch(nums, target);
        int r = binarySearch(nums, target + 1);//r在开区间，处于越界状态
        //当l越界或者l不等于target
        if (nums.length == l || nums[l] != target)
            return new int[]{-1, -1};
        return new int[]{l, r - 1};
    }

    public int binarySearch(int[] nums, int target) {
        //左闭右开
        int l = 0, r = nums.length;
        while (l < r) {
            int m = l + (r - l) / 2;
            //通过二分持续向左寻找左边界
            if (nums[m] >= target) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
}
