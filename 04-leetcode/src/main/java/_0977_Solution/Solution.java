package _0977_Solution;

import java.util.Arrays;

/**
 * @author YeYaqiao
 * 977. 有序数组的平方
 */
public class Solution {

    //双指针法
    public int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        int length = nums.length;
        int head = 0;
        int last = length - 1;
        int[] result = new int[length];
        while (head < last) {
            //每次找出一个最大的数放在新数组的末尾
            if (nums[head] > nums[last]) {
                result[length - 1] = nums[head];
                head++;
            } else {
                result[length - 1] = nums[last];
                last--;
            }
            length--;
        }
        result[0] = nums[head];
        return result;
    }

    //先平方，再排序
//    public int[] sortedSquares(int[] nums) {
//        for (int i = 0; i < nums.length; i++) {
//            nums[i] = nums[i] * nums[i];
//        }
//        Arrays.sort(nums);
//        return nums;
//    }
}
