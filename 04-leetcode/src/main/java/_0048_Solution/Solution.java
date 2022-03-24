package _0048_Solution;

/**
 * @author YeYaqiao
 * 48. 旋转图像
 */
public class Solution {
    public void rotate(int[][] matrix) {

        //先沿着反斜线交换
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        //再沿着中间竖线交换
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix[i].length - j - 1];
                matrix[i][matrix[i].length - j - 1] = temp;
            }
        }
    }
}
