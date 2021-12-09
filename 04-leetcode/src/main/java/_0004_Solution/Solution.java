package _0004_Solution;

import java.util.Arrays;

/**
 * @author YeYaqiao
 * 4. 寻找两个正序数组的中位数
 */
public class Solution {
    //暴力法，合并两个数组后再计算中位数
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] merge = new int[nums1.length + nums2.length];
        int n1 = 0, n2 = 0, m = 0;
        while (m < merge.length) {
            if (n1 == nums1.length && n2 < nums2.length) {
                merge[m] = nums2[n2];
                n2++;
            } else if (n2 == nums2.length && n1 < nums1.length) {
                merge[m] = nums1[n1];
                n1++;
            } else {
                if (nums1[n1] > nums2[n2]) {
                    merge[m] = nums2[n2++];
                } else {
                    merge[m] = nums1[n1++];
                }
            }
            m++;
        }
        if (merge.length % 2 == 0)
            return (merge[merge.length / 2] + merge[merge.length / 2 - 1]) / 2.0;
        return merge[merge.length / 2];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.findMedianSortedArrays(new int[]{1, 3}, new int[]{2});
    }
}
