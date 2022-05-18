package _0215_Solution;

import java.util.Arrays;

/**
 * @author YeYaqiao
 * 215. 数组中的第K个最大元素
 */
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        int pointer=nums.length-1;
        int count=1;
        int tmp;
        while (pointer>=0){
            if(k==count)
                return nums[pointer];
            pointer--;
            if(nums[pointer])
                count++;
        }

        return 0;
    }
}
