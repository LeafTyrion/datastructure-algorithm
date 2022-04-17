package _0130_Solution;

/**
 * @author YeYaqiao
 * 130. 被围绕的区域
 */
public class Solution {
    int height, width;

    public void solve(char[][] board) {
        if (board == null)
            return;
        height = board.length;
        if (height == 0)
            return;
        width = board[0].length;
        if (width == 0)
            return;

        for (int i = 0; i < height; i++) {
            dfs(board, i, 0);
            dfs(board, i, width - 1);
        }

        for (int j = 1; j < width - 1; j++) {
            dfs(board, 0, j);
            dfs(board, height - 1, j);
        }
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (board[i][j] == 'A')
                    board[i][j] = 'O';
                else if (board[i][j] == 'O')
                    board[i][j] = 'X';
            }
        }
    }

    private void dfs(char[][] board, int i, int j) {
        //边界判断和元素判断
        if (i < 0 || i >= height || j < 0 || j >= width || board[i][j] != 'O')
            return;
        board[i][j] = 'A';
        dfs(board, i + 1, j);
        dfs(board, i - 1, j);
        dfs(board, i, j + 1);
        dfs(board, i, j - 1);
    }

}
