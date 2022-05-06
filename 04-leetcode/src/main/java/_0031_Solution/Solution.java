package _0031_Solution;

/**
 * @author YeYaqiao
 * 31. 下一个排列
 */
public class Solution {
    //找出比当前排列稍大的排列
    public void nextPermutation(int[] nums) {
        int max = -1;
        int head = -1;
        int tail = nums.length - 1;

        //找一个nums[k]<nums[k+1]的位置k
        for (int i = tail - 1; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                head = i;
                break;
            }
        }

        //然后从nums[k+1]到length之间找一个比nums[k]稍大的元素，两者进行交换
        //反转 nums[k+1]到length即可
        if (head == -1)
            reverse(nums, 0, tail);
        else {
            for (int i = tail; i > head; i--) {
                if (nums[i] > nums[head]) {
                    max = i;
                    break;
                }
            }

            swap(nums, head, max);
            reverse(nums, head + 1, tail);
        }

    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.nextPermutation(new int[]{2, 3, 1, 3, 3});
    }
}
