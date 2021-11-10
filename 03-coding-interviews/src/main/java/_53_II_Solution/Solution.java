package _53_II_Solution;

/**
 * @author YeYaqiao
 * 剑指 Offer 53 - II. 0～n-1中缺失的数字
 */
public class Solution {

    //二分法
    public int missingNumber(int[] nums) {

        int min = 0, max = nums.length - 1;
        while (min <= max) {
            int mid = min + (max - min) / 2;
            if (nums[mid] == mid) {
                min = mid + 1;
            } else if (nums[mid] < mid) {
                max = mid;
            } else if (nums[mid] > mid) {
                max = mid - 1;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.missingNumber(new int[]{0});
    }

    //总数法，理论和减去实际和
//    public int missingNumber(int[] nums) {
//        int sum = (nums.length + 1) * nums.length / 2;
//        return sum - Arrays.stream(nums).sum();
//
//    }

    //暴力遍历
//    public int missingNumber(int[] nums) {
//
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] != i)
//                return i;
//        }
//        return nums[nums.length - 1] + 1;
//    }

}
