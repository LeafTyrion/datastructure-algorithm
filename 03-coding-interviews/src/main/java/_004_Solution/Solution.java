package _004_Solution;

/**
 * @author YeYaqiao
 * 剑指 Offer 04. 二维数组中的查找
 */
public class Solution {

    //二维数组依次排除行列法
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length > 0 && matrix[0].length > 0) {
            int row = 0;
            int column = matrix[0].length - 1;
            while (row < matrix.length && column >= 0) {
                if (matrix[row][column] > target)
                    column--;
                else if (matrix[row][column] < target)
                    row++;
                else return true;
            }
        }
        return false;
    }
}

