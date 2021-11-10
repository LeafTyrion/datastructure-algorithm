package _011_Solution;

/**
 * @author YeYaqiao
 * 剑指 Offer 11. 旋转数组的最小数字
 */
public class Solution {
    //二分法
    public int minArray(int[] numbers) {
        int min = 0;
        int max = numbers.length - 1;
        while (min < max) {
            int mid = min + (max - min) / 2;
            if (numbers[mid] > numbers[max]) {
                min = mid + 1;
            } else if (numbers[mid] < numbers[max]) {
                max = mid;
            } else if (numbers[mid] == numbers[max]) {
                max--;
            }
        }
        return numbers[max];
    }

    //暴力遍历
//    public int minArray(int[] numbers) {
//        for (int i = 1; i < numbers.length; i++) {
//            if (numbers[i - 1] > numbers[i])
//                return numbers[i];
//        }
//        return numbers[0];
//    }


}
