package _29_Solution;

/**
 * @author YeYaqiao
 * 剑指 Offer 29. 顺时针打印矩阵
 */
public class Solution {
    //模拟
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0)
            return new int[0];
        int row = matrix.length;
        int column = matrix[0].length;
        int l = 0, r = column - 1, t = 0, b = row - 1, index = 0;
        int[] result = new int[row * column];
        //按照上右下左的顺序对矩阵从外到里进行遍历
        while (true) {
            //先从上边一行开始遍历
            for (int i = l; i <= r; i++)
                result[index++] = matrix[t][i];
            //上面第一行遍历完后下一次应该遍历第二行，则 执行 ++t 操作
            //但如果越过 b，则表示遍历完成
            if (++t > b) break;
            //遍历右面一列，r 不变，row++
            for (int i = t; i <= b; i++) {
                result[index++] = matrix[i][r];
            }
            if (--r < l) break;
            //遍历底部一行
            for (int i = r; i >= l; i--) {
                result[index++] = matrix[b][i];
            }
            if (--b < t) break;
            //最后遍历左边一列
            for (int i = b; i >= t; i--) {
                result[index++] = matrix[i][l];
            }
            if (++l > r) break;
        }
        return result;
    }
}
