package _0283_Solution;

import java.util.Arrays;

/**
 * @author YeYaqiao
 * 283. 移动零
 */
public class Solution {

    //双指针
    public void moveZeroes(int[] nums) {
        int head = 0, end = 0;
        while (end < nums.length) {
            if (nums[end] != 0) {
                int temp = nums[end];
                nums[end] = nums[head];
                nums[head] = temp;
                head++;
            }
            end++;
        }
    }

    //填充法
//    public void moveZeroes(int[] nums) {
//        int j = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] != 0) {
//                nums[j++] = nums[i];
//            }
//        }
//        while (j < nums.length) {
//            nums[j++] = 0;
//        }
//    }

    //冒泡交换
//    public void moveZeroes(int[] nums) {
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] == 0) {
//                //若当前元素为0，则找出它之后的第一个不为0的元素进行交换
//                for (int j = i + 1; j < nums.length; j++) {
//                    if (nums[j] == 0)
//                        continue;
//                    int temp = nums[j];
//                    nums[j] = nums[i];
//                    nums[i] = temp;
//                    //交换完毕后则跳出当前循环，进行下一个元素的比对和交换操作
//                    break;
//                }
//            }
//        }
//    }

    //辅助数组
//    public void moveZeroes(int[] nums) {
//        int[] result = new int[nums.length];
//        int index = 0;
//        for (int num : nums) {
//            if (num != 0) {
//                result[index] = num;
//                index++;
//            }
//        }
//        System.arraycopy(result, 0, nums, 0, nums.length);
//    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.moveZeroes(new int[]{1, 1, 0, 3, 12});
    }
}
