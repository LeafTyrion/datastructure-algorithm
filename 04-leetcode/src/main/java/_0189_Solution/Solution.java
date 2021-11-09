package _0189_Solution;

/**
 * @author YeYaqiao
 * 189. 旋转数组
 */
public class Solution {


    //数组翻转3次
    public void rotate(int[] nums, int k) {
        reverse(0, nums.length - 1, nums);
        reverse(0, k % nums.length - 1, nums);
        reverse(k % nums.length, nums.length - 1, nums);
    }

    private void reverse(int start, int end, int[] nums) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    //使用辅助数组
//    public void rotate(int[] nums, int k) {
//        int length = nums.length;
//        int[] result = new int[length];
//        k %= length;//取余简化
//        for (int i = 0; i < length; i++) {
//            result[(i + k) % length] = nums[i];
//        }
//        //将新数组内容赋值
//        System.arraycopy(result, 0, nums, 0, length);
//    }
}
