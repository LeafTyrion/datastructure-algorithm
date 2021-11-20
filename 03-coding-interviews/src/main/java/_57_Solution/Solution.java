package _57_Solution;

import java.util.HashSet;

/**
 * @author YeYaqiao
 * 剑指 Offer 57. 和为s的两个数字
 */
public class Solution {

    //双指针
    public int[] twoSum(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        //当两个指针重合，说明并不存在两元素和为 target
        while (i < j) {
            int temp = nums[i] + nums[j];
            //temp < target ,说明左端的值太小，向右移动左指针
            if (temp < target)
                i++;
                //temp > target ,说明右端的值太大，向左移动右指针
            else if (temp > target)
                j--;
            else
                return new int[]{nums[i], nums[j]};
        }
        return new int[]{};
    }

    //hashset
//    public int[] twoSum(int[] nums, int target) {
//        HashSet<Integer> set = new HashSet<>();
//        for (int num : nums) {
//            if (set.contains(target - num)) {
//                return new int[]{num, target - num};
//            }
//            set.add(num);
//        }
//        return new int[]{};
//    }

    //暴力法，会超时
//    public int[] twoSum(int[] nums, int target) {
//        int[] result = new int[2];
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[i] + nums[j] == target) {
//                    result[0] = nums[i];
//                    result[1] = nums[j];
//                }
//            }
//        }
//        return result;
//    }
}
