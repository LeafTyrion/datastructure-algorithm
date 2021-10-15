package _53_II_Solution;

import java.util.Arrays;

/**
 * @author YeYaqiao
 * 剑指 Offer 53 - II. 0～n-1中缺失的数字
 */
public class Solution {

    //暴力遍历
//    public int missingNumber(int[] nums) {
//
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] != i)
//                return i;
//        }
//        return nums[nums.length - 1] + 1;
//    }

    //总数法，理论和减去实际和
    public int missingNumber(int[] nums) {
        int sum = (nums.length + 1) * nums.length / 2;
        return sum - Arrays.stream(nums).sum();

    }

//    //二分法
//    public int missingNumber(int[] nums) {
//
//
//
//    }
}
