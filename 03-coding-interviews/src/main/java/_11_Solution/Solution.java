package _11_Solution;

/**
 * @author YeYaqiao
 * 剑指 Offer 11. 旋转数组的最小数字
 */
public class Solution {

    //暴力遍历
//    public int minArray(int[] numbers) {
//        for (int i = 1; i < numbers.length; i++) {
//            if (numbers[i - 1] > numbers[i])
//                return numbers[i];
//        }
//        return numbers[0];
//    }

    //二分法
    public int minArray(int[] numbers) {

        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (numbers[mid] > numbers[right]) {
                left = mid + 1;
            } else if (numbers[mid] < numbers[right]) {
                right = mid;
            } else {
                right--;
            }
        }
        return numbers[left];
    }

}
