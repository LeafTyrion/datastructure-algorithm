package _12_Solution;

/**
 * @author YeYaqiao
 * 剑指 Offer 12. 矩阵中的路径
 */
public class Solution {

    //dfs 深度优先搜索，递归，优化版
    public boolean exist(char[][] board, String word) {
        //遍历整个二维数组，传入当前元素，判断当前元素是否有和word对应的元素
        // 若有，则再判断当前元素的上下左右是否有与目标字符串相对应的元素
        //二维数组的遍历只负责传入与word 第一个位置的元素匹配的二维数组的元素
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, word.toCharArray(), i, j, 0))
                    return true;
            }
        }
        return false;
    }

    //递归寻找整个二维数组，判断第一次传入的元素的相邻位置的元素是否和word匹配
    private boolean dfs(char[][] board, char[] word, int i, int j, int k) {
        //若二维数组越界获取元素不相等，则直接返回false
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[k])
            return false;
        //若元素相等，并且此时已经比对到了word最后一个字符，则证明board中存在word
        if (word.length - 1 == k)
            return true;
        //将当前数组元素标记为空，防止下面递归时被重复访问
        board[i][j] = ' ';
        //继续递归判断当前元素的周围元素(上下左右的元素)是否和word相应位置的元素相等
        boolean result = dfs(board, word, i + 1, j, k + 1) ||
                dfs(board, word, i - 1, j, k + 1) ||
                dfs(board, word, i, j + 1, k + 1) ||
                dfs(board, word, i, j - 1, k + 1);
        //恢复被标记的元素
        board[i][j] = word[k];
        return result;
    }

    //dfs 深度优先搜索，递归
//    public boolean exist(char[][] board, String word) {
//        char[] words = word.toCharArray();
//        for (int i = 0; i < board.length; i++) {
//            for (int j = 0; j < board[0].length; j++) {
//                if (dfs(board, words, i, j, 0))
//                    return true;
//            }
//        }
//        return false;
//    }
//
//    boolean dfs(char[][] board, char[] word, int i, int j, int k) {
//        //若二维数组越界，则直接返回false
//        if(i>=board.length)
//            return false;
//        if(i<0)
//            return false;
//        if(j>board[0].length)
//            return false;
//        if(j<0)
//            return false;
//        //若二维数组中的当前元素不等于字符串中的元素，则返回false
//        if(board[i][j]!=word[k])
//            return false;
//        //若已经匹配到了字符串中的最后一个元素，则证明二维数组中存在此字符串，则返回true
//        if (k == word.length - 1) return true;
//        //若当前元素等于字符串中的元素，则将当前元素设置成空
//        board[i][j] = '\0';
//        //继续按照下、上、右、左的顺序进行递归，寻找二维数组与字符串对应的元素
//        boolean res = dfs(board, word, i + 1, j, k + 1) ||
//                dfs(board, word, i - 1, j, k + 1) ||
//                dfs(board, word, i, j + 1, k + 1) ||
//                dfs(board, word, i, j - 1, k + 1);
//        //寻找完毕回溯上将当前调用栈对应的位置的元素值回复
//        board[i][j] = word[k];
//        //返回递归结果
//        return res;
//    }
}
