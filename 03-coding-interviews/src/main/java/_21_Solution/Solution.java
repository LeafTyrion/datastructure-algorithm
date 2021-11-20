package _21_Solution;

/**
 * @author YeYaqiao
 * 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
 */
public class Solution {
    //双指针碰撞
    public int[] exchange(int[] nums) {
        int i = 0, j = nums.length - 1, tmp;
        while (i < j) {
            //奇数的二进制末尾一定是1，偶数一定是0
            //先寻找一个奇数
            while (i < j && (nums[i] & 1) == 1) i++;
            //再寻找一个偶数
            while (i < j && (nums[j] & 1) == 0) j--;
            //交换两数位置
            tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        return nums;
    }

    //双指针遍历
//    public int[] exchange(int[] nums) {
//
//        int[] result = new int[nums.length];
//
//        int startIndex = 0;
//        int endIndex = nums.length - 1;
//        for (int i = nums.length - 1; i >= 0; i--) {
//            int cur = nums[i];
//            if (cur % 2 == 0) {
//                result[endIndex] = cur;
//                endIndex--;
//            } else {
//                result[startIndex] = cur;
//                startIndex++;
//            }
//        }
//        return result;
//    }
}
