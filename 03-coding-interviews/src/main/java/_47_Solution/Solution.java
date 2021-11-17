package _47_Solution;

/**
 * @author YeYaqiao
 * 剑指 Offer 47. 礼物的最大价值
 */
public class Solution {

    //动态规划，优化代码
    public int maxValue(int[][] grid) {
        int x = grid.length;
        int y = grid[0].length;

        //因为第一行各个位置上的和是其左边的元素相加所得，先计算出第一行每个位置上的和
        for (int i = 1; i < y; i++) {
            grid[0][i] += grid[0][i - 1];
        }
        //列同上
        for (int i = 1; i < x; i++) {
            grid[i][0] += grid[i - 1][0];
        }
        //从[1],[1]位置开始，需要比较判断左边和上边的值
        for (int i = 1; i < x; i++) {
            for (int j = 1; j < y; j++) {
                grid[i][j] += Math.max(grid[i][j - 1], grid[i - 1][j]);
            }
        }
        //返回右下角的结果
        return grid[x - 1][y - 1];
    }


    //动态规划方程 f(i,j)=Max{f(i,j-1),f(i-1,j)}+grid[i][j]
    //当前元素位置的最大值为当前元素值加上其上方或者其左方元素位置的最大值
//    public int maxValue(int[][] grid) {
//        int m = grid.length, n = grid[0].length;
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                //位置从[0][0]开始，必选值，且元素只能向下或者向右移动
//                if (i == 0 && j == 0) continue;
//                //当i==0时，元素只能向右移动，所以当前元素只需要和其左边的元素进行相加获取和
//                if (i == 0) grid[i][j] += grid[i][j - 1];
//                //当j==0时，当前元素只能和上面的元素相加获取和
//                else if (j == 0) grid[i][j] += grid[i - 1][j];
//                //当i和j都不等于0，则比较当前位置的上面或者左面的元素和，选择一个最大值即可
//                else grid[i][j] += Math.max(grid[i][j - 1], grid[i - 1][j]);
//            }
//        }
//        return grid[m - 1][n - 1];
//    }


}
