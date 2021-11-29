package _39_Solution;

import java.util.Arrays;

/**
 * @author YeYaqiao
 * 剑指 Offer 39. 数组中出现次数超过一半的数字
 */
public class Solution {

    //摩尔投票法，抵消法
    public int majorityElement(int[] nums) {
        int target = 0, votes = 0;
        for (int num : nums) {
            if (votes == 0)
                target = num;
            if (num == target)
                votes++;
            if (num != target)
                votes--;
        }
        return target;
    }

    //排序法
//    public int majorityElement(int[] nums) {
//        Arrays.sort(nums);
//        return nums[nums.length / 2];
//    }


    //利用 hashmap
//    public int majorityElement(int[] nums) {
//        int result = 0;
//        int numbers = 0;
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int num : nums) {
//            if (map.containsKey(num))
//                map.put(num, map.get(num) + 1);
//            else
//                map.put(num, 1);
//        }
//
//        for (Integer key : map.keySet()) {
//            if (map.get(key) > numbers) {
//                result = key;
//                numbers = map.get(key);
//            }
//        }
//        return result;
//    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.majorityElement(new int[]{3, 2, 3});
    }
}
