package _03_Solution;

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

            //若当前索引值和元素值相等，则说明元素在正确的位置，则继续遍历下一个元素
            if (nums[i] == i) {
                i++;
                continue;
            }

            //若当前元素不在正确的位置上，但是其正确的位置以及放置了正确的值，则说明这个元素有重复
            if (nums[nums[i]] == nums[i])
                return nums[i];

            //交换当前元素到其正确的索引位置上
            int temp = nums[i];
            nums[i] = nums[temp];
            nums[temp] = temp;
        }
        return -1;
    }

}
