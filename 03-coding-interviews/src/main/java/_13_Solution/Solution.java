package _13_Solution;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author YeYaqiao
 * 剑指 Offer 13. 机器人的运动范围
 */
public class Solution {

    //bfs 广度优先搜索,从左上至右下开始搜索
    public int movingCount(int m, int n, int k) {
        int result = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 0, 0,});
        boolean[][] visited = new boolean[m][n];
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int i = node[0], j = node[1], si = node[2], sj = node[3];
            if (i >= m || j >= n || k < si + sj || visited[i][j])
                continue;
            visited[i][j] = true;
            result++;

            //获取当前列下一行元素的位数之和
            int sumI = (i + 1) % 10 != 0 ? si + 1 : si - 8;
            //获取当前行下一列元素的位数之和
            int sumJ = (j + 1) % 10 != 0 ? sj + 1 : sj - 8;
            queue.add(new int[]{i + 1, j, sumI, sj});
            queue.add(new int[]{i, j + 1, si, sumJ});
        }
        return result;
    }

    //dfs 深度优先搜索
//    private int m, n, k;
//    private boolean visited[][];
//
//    public int movingCount(int m, int n, int k) {
//        this.m = m;
//        this.n = n;
//        this.k = k;
//        this.visited = new boolean[m][n];
//        //从矩阵的左上角开始递归遍历，进行dfs
//        return dfs(0, 0, 0, 0);
//    }
//
//    private int dfs(int i, int j, int si, int sj) {
//        //若要访问的当前元素已经越界、位数之和超过了k或者已经被访问过，则表示没有可以走的路，返回0
//        if (i >= m || j >= n || k < si + sj || visited[i][j])
//            return 0;
//        //若当前元素符合访问要求，则将存入 visited 中，标记成已访问
//        visited[i][j] = true;
//        //继续递归判断当前元素的周围元素是否符合要求
//        //计算要递归的下一个元素的横坐标位数之和和纵坐标位数之和
//        //获取当前列下一行元素的位数之和
//        int sumI = (i + 1) % 10 != 0 ? si + 1 : si - 8;
//        //获取当前行下一列元素的位数之和
//        int sumJ = (j + 1) % 10 != 0 ? sj + 1 : sj - 8;
//        //递归并获取结果+1
//        return 1 + dfs(i + 1, j, sumI, sj) + dfs(i, j + 1, si, sumJ);
//    }
}
