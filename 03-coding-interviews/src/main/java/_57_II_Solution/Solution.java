package _57_II_Solution;


import java.util.ArrayList;
import java.util.List;

/**
 * @author YeYaqiao
 * 剑指 Offer 57 - II. 和为s的连续正数序列
 */
public class Solution {

    //滑动窗口，双指针
    public int[][] findContinuousSequence(int target) {
        List<int[]> list = new ArrayList<>();
        //窗口内元素的和
        int sum = 0;
        //初始化左右指针
        int left = 1, right = 1;
        while (right <= target) {
            if (sum < target) {
                //当窗口内元素的和小于target时，
                //左指针left不动，向右移动右指针right
                //先计算当前窗口内的和
                sum = sum + right;
                right++;
            } else if (sum > target) {
                //当窗口内元素的和大于target时，
                //右指针right不动，向右移动左指针left
                //并减去左指针越过的值
                sum = sum - left;
                left++;
            } else {
                int[] array = new int[right - left];
                for (int k = left; k < right; k++) {
                    array[k - left] = k;
                }
                list.add(array);
                sum = sum - left;
                left++;
            }
        }
        int[][] result = new int[list.size()][];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        return result;


//        List<int[]> list = new ArrayList<>();
//        int sum = 0;
//        int l = 1;
//        for (int r = 1; r < target; r++) {
//            sum += r;
//            while (sum > target) {
//                sum -= l++;
//            }
//            if (sum == target) {
//                int[] temp = new int[r - l + 1];
//                for (int i = 0; i < temp.length; i++) {
//                    temp[i] = l + i;
//                }
//                list.add(temp);
//            }
//        }
//
//        int[][] res = new int[list.size()][];
//        for (int i = 0; i < res.length; i++) {
//            res[i] = list.get(i);
//        }
//        return res;
    }


    //暴力优化
//    public int[][] findContinuousSequence(int target) {
//        List<int[]> result = new ArrayList<>();
//        List<Integer> temp = new ArrayList<>();
//
//        for (int i = 1; i <= target / 2; i++) {
//            int next = i + 1;
//            int sum = i;
//            temp.clear();
//            temp.add(i);
//            while (next < target && sum < target) {
//                sum += next;
//                temp.add(next);
//                if (sum == target) {
//                    int[] array = new int[temp.size()];
//                    for (int i1 = 0; i1 < temp.size(); i1++) {
//                        array[i1] = temp.get(i1);
//                    }
//                    result.add(array);
//                }
//                next++;
//            }
//        }
//        return result.toArray(new int[0][]);
//    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.findContinuousSequence(5);
    }
}
