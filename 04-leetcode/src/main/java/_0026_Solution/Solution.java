package _0026_Solution;

/**
 * @author YeYaqiao
 * 26. 删除有序数组中的重复项
 */
public class Solution {

    //使用快慢指针
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int left = 0;
        int right = 1;
        while (right < nums.length) {
            if (nums[left] == nums[right]) {
                right++;
            } else {
                left++;
                nums[left] = nums[right];
            }
        }
        return left + 1;
    }
}
