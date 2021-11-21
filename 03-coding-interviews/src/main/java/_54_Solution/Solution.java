package _54_Solution;

/**
 * @author YeYaqiao
 * 剑指 Offer 54. 二叉搜索树的第k大节点
 */
public class Solution {

    //深度优先搜索 dfs deep first search
    //二叉搜索树（二叉排序树）左子节点<当前节点<右子节点
    //中序遍历
    int result, k;

    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return result;
    }

    //采用右中左的顺序获取元素，则可以从大到小获取元素
    private void dfs(TreeNode root) {
        if (root == null)
            return;
        dfs(root.right);
        //每递归一次，--k，当k等于0，则表示递归到了第k大的元素
        if (--k == 0)
            result = root.val;
        dfs(root.left);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
