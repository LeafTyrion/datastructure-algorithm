package _0011_Solution;

/**
 * @author YeYaqiao
 * 11. 盛最多水的容器
 */
public class Solution {

    //双指针，从两端向中间寻找短板尽量长的板子
    public int maxArea(int[] height) {
        int result = 0;
        int i = 0, j = height.length - 1;
        while (i < j) {
            result = Math.max(result, (j - i) * Math.min(height[i], height[j]));
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return result;
    }

    //暴力法，会超时
//    public int maxArea(int[] height) {
//        int result = 0;
//        for (int i = 0; i < height.length - 1; i++) {
//            for (int j = i + 1; j < height.length; j++) {
//                int currentHeight = Math.min(height[i], height[j]);
//                result = Math.max(result, currentHeight * (j - i));
//            }
//        }
//        return result;
//    }
}
