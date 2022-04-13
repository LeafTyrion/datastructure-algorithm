package _0200_Solution;

/**
 * @author YeYaqiao
 * 200. 岛屿数量
 */
public class Solution {

    //dfs
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        int height = grid.length;
        int width = grid[0].length;
        int result = 0;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    result++;
                }
            }
        }
        return result;
    }

    private void dfs(char[][] grid, int height, int width) {
        if (height < 0 || width < 0 || height >= grid.length || width >= grid[0].length || grid[height][width] == '0')
            return;
        grid[height][width] = '0';
        dfs(grid, height, width + 1);
        dfs(grid, height + 1, width);
        dfs(grid, height, width - 1);
        dfs(grid, height - 1, width);
    }
}
