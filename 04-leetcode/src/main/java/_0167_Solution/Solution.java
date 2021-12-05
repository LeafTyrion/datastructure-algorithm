package _0167_Solution;

/**
 * @author YeYaqiao
 * 167. 两数之和 II - 输入有序数组
 */
public class Solution {

    //双指针
    //当两个索引位置元素的和大于 target 时，右指针左移
    //小于 target 时，左指针右移
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left <= right) {
            int sum = numbers[left] + numbers[right];
            if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;
            } else {
                return new int[]{left + 1, right + 1};
            }
        }
        return new int[]{};
    }

    //二分法，先固定一个数，然后二分查找另一个数
//    public int[] twoSum(int[] numbers, int target) {
//        for (int i = 0; i < numbers.length; i++) {
//            int findTarget = target - numbers[i];
//            int min = i + 1;
//            int max = numbers.length - 1;
//            while (min <= max) {
//                int mid = min + (max - min) / 2;
//                if (findTarget < numbers[mid]) {
//                    max = mid - 1;
//                } else if (findTarget > numbers[mid]) {
//                    min = mid + 1;
//                } else if (findTarget == numbers[mid]) {
//                    return new int[]{i + 1, mid + 1};
//                }
//            }
//        }
//        return new int[]{};
//    }

    //暴力法
//    public int[] twoSum(int[] numbers, int target) {
//        for (int i = 0; i < numbers.length - 1; i++) {
//            for (int j = i + 1; j < numbers.length; j++) {
//                if (numbers[i] + numbers[j] == target)
//                    return new int[]{i + 1, j + 1};
//            }
//        }
//        return new int[]{};
//    }
}
