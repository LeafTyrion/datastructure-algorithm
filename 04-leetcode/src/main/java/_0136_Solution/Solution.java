package _0136_Solution;

/**
 * @author YeYaqiao
 * 136. 只出现一次的数字
 */
public class Solution {

    //异或运算
    public int singleNumber(int[] nums) {

        int result = 0;
        for (int num : nums) {
            //元素要么出现一次，要么出现两次，出现两次的元素可以用异或运算抵消成0
            result = result ^ num;
        }
        return result;
    }

    //排序遍历
//    public int singleNumber(int[] nums) {
//        Arrays.sort(nums);
//        int length = nums.length;
//        if(length==1)
//            return nums[0];
//        for (int i = 0; i < nums.length; i++) {
//            if (i == 0 && nums[i] != nums[i + 1])
//                return nums[i];
//            if (i == length - 1 && nums[i] != nums[i - 1])
//                return nums[i];
//            if (nums[i] != nums[i + 1] && nums[i] != nums[i - 1])
//                return nums[i];
//        }
//        return -1;
//    }
}
