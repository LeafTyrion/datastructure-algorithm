package _55_I_Solution;

/**
 * @author YeYaqiao
 * 剑指 Offer 55 - I. 二叉树的深度
 */
public class Solution {

    //dfs deep search first 深度优先搜索
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        //递归获取各个节点左右子树的个节点个数
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    //bfs breath search first 广度优先搜索
//    public int maxDepth(TreeNode root) {
//        int result = 0;
//        if (root == null)
//            return result;
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.add(root);
//        while (!queue.isEmpty()) {
//            result++;
//            for (int i = queue.size(); i > 0; i--) {
//                TreeNode node = queue.poll();
//                if (node.left != null) queue.add(node.left);
//                if (node.right != null) queue.add(node.right);
//            }
//        }
//        return result;
//    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
