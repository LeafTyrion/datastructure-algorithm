package _0215_Solution;

/**
 * @author YeYaqiao
 * 215. 数组中的第K个最大元素
 */
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        int length = nums.length;
        quickSort(nums, 0, length - 1);
        return nums[length - k];
    }

    private void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int partition = partition(nums, left, right);
            quickSort(nums, left, partition - 1);
            quickSort(nums, partition + 1, right);
        }

    }

    private int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        while (left < right) {
            while (nums[right] >= pivot && left < right)
                right--;
            nums[left] = nums[right];
            while (nums[left] <= pivot && left < right)
                left++;
            nums[right] = nums[left];
        }
        nums[left] = pivot;
        return left;
    }


//    public int findKthLargest(int[] nums, int k) {
//        Arrays.sort(nums);
//        return nums[nums.length - k + 1];
//    }

}
