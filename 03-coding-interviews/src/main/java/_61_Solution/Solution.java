package _61_Solution;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author YeYaqiao
 * 剑指 Offer 61. 扑克牌中的顺子
 */
public class Solution {

    //利用排序 + 遍历，两个元素之间肯定不相等
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int joker = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0)
                joker++;
            else if (nums[i] == nums[i + 1])
                return false;
        }
        return nums[nums.length - 1] - nums[joker] < 5;
    }

    //利用 hashset
    //顺子中除0以外没有重复的牌，并且最大值减最小值不能超过5
//    public boolean isStraight(int[] nums) {
//        int min = 0;
//        int max = 0;
//        Set<Integer> set = new HashSet<>();
//        for (int num : nums) {
//            if (num == 0)
//                continue;
//            max = Math.max(num, max);
//            min = Math.min(num, min);
//            if (set.contains(num))
//                return false;
//            set.add(num);
//        }
//        return max - min < 5;
//    }
}
