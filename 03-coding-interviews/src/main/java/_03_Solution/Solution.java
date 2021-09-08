package _03_Solution;

import java.util.HashSet;
import java.util.Set;

/**
 * @author YeYaqiao
 * 剑指 Offer 03. 数组中重复的数字
 */
public class Solution {
//    暴力法
//    public int findRepeatNumber(int[] nums) {
//
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[i] == nums[j])
//                    return nums[i];
//            }
//        }
//        return -1;
//    }

//    利用 HashSet
//    public int findRepeatNumber(int[] nums) {
//
//        Set<Integer> set = new HashSet<>();
//        for (Integer num : nums) {
//            if (set.contains(num)) {
//                return num;
//            }
//            set.add(num);
//        }
//        return -1;
//    }

    //    原地交换
    public static int findRepeatNumber(int[] nums) {

        int i = 0;
        while (i < nums.length) {

            if (nums[i] == i){
                i++;
                continue;
            }
            if (nums[nums[i]] == nums[i])
                return nums[i];
            int temp = nums[i];
            nums[i] = nums[temp];
            nums[temp] = temp;
        }
        return -1;
    }

}
