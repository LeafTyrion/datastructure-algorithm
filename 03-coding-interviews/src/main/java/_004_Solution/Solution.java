package _004_Solution;

/**
 * @author YeYaqiao
 * 剑指 Offer 04. 二维数组中的查找
 */
public class Solution {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int i = 0;
        int j = matrix.length - 1;
        while (i < matrix[0].length && j > 0) {
            if (matrix[i][j] > target) {
                j--;
            } else if (matrix[i][j] < target) {
                i++;
            } else
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.findNumberIn2DArray(new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}}, 5);
    }
}
