package _53_Solution;

import java.util.OptionalDouble;

/**
 * @author YeYaqiao
 * 剑指 Offer 53 - I. 在排序数组中查找数字 I
 */
public class Solution {

    //暴力遍历统计
//    public int search(int[] nums, int target) {
//
//        int result = 0;
//
//        for (int num : nums) {
//            if (num == target)
//                result++;
//        }
//        return result;
//    }

    //排序数组的查找一般涉及 二分法
    public int search(int[] nums, int target) {
        if (nums.length == 0)
            return 0;

        int startIndex = getStartIndex(nums, target);

        int endIndex = getEndIndex(nums, target);

        if (startIndex == -1)
            return 0;
        return endIndex - startIndex + 1;
    }
    private int getStartIndex(int[] nums, int target) {
        int min = 0;
        int max = nums.length - 1;
        int mid = -1;

        while (min < max) {
            //存在整型溢出风险
//            mid = (min + max) / 2;

            mid = min + (max - min) / 2;

            if (nums[mid] < target) {
                min = mid + 1;
            } else if (nums[mid] == target) {
                max = mid;
            } else if (nums[mid] > target) {
                max = mid - 1;
            }
        }

        if (nums[min] == target)
            return min;
        return -1;
    }
    private int getEndIndex(int[] nums, int target) {
        int min = 0;
        int max = nums.length - 1;
        int mid = -1;

        while (min < max) {
            //存在整型溢出风险
//            mid = (min + max) / 2;

            mid = min + (max - min + 1) / 2;

            if (nums[mid] < target) {
                min = mid + 1;
            } else if (nums[mid] == target) {
                min = mid;
            } else if (nums[mid] > target) {
                max = mid - 1;
            }
        }

        if (nums[max] == target)
            return max;
        return -1;
    }

}
